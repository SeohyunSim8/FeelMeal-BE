package feelmeal.api.theme.service;

import feelmeal.domain.menu.entity.Menu;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import feelmeal.api.member.service.MemberServiceImpl;
import feelmeal.api.theme.controller.dto.response.*;
import feelmeal.api.theme.service.dto.*;
import feelmeal.domain.member.entity.Member;
import feelmeal.domain.restaurant.repository.RestaurantRepository;
import feelmeal.domain.restaurant.repository.StationRepository;
import feelmeal.domain.menu.entity.ThemeLike;
import feelmeal.domain.menu.repository.MenuRepository;
import feelmeal.global.common.entity.BaseEntity;
import feelmeal.global.common.entity.Constant;
import feelmeal.global.common.exception.CustomException;
import feelmeal.global.common.exception.ResponseCode;
import feelmeal.global.common.response.PageResponse;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ThemeServiceImpl implements ThemeService {
    private final MenuRepository menuRepository;
//    private final ThemeLikeRepository themeLikeRepository;

    private final StationRepository stationRepository;
    private final RestaurantRepository restaurantRepository;

    private PageRequest pageRequest;

    private final MemberServiceImpl memberService;

    public PageResponse<GetLocationThemeListResponse> getLocationThemeList(GetLocationThemeListServiceDto dto) {
        Constant.LocationCategory locationCategory;
        Long valueId = dto.getValue();
        pageRequest = PageRequest.of(dto.getPage() - 1, 10);
        Page<GetLocationThemeListResponse> response;

        // 카테고리 검사
        try {
            locationCategory = Constant.LocationCategory.valueOf(dto.getCategory().toUpperCase());

        } catch (IllegalArgumentException e) {
            throw new CustomException(ResponseCode.LOCATION_CATEGORY_NOT_FOUND);
        }

        response = switch (locationCategory) {
            // 시/도별 역 목록 조회
            case CITY -> stationRepository.findStationsWithAnyThemeOrderByName(pageRequest, valueId);

            // 역별 방탈출 카페 지점 목록 조회
            case STATION -> restaurantRepository.findActivePointsWithAnyThemeOrderByName(pageRequest, valueId);

            // 방탈출 카페 지점별 테마 목록 조회
            case POINT ->
                    menuRepository.findThemeByPointIdAndStatusOrderByName(pageRequest, valueId, BaseEntity.Status.ACTIVE);

            default -> throw new CustomException(ResponseCode.LOCATION_CATEGORY_NOT_FOUND);
        };

        return PageResponse.from(response);
    }

    // 숙련도 기반 방탈출 카페 테마 목록 조회 API
    public GetProficiencyThemeListResponse getProficiencyThemeList(GetProficiencyThemeListServiceDto dto) {
        // 숙련도 검사
        Constant.Proficiency proficiency;
        try {
            proficiency = Constant.Proficiency.valueOf(dto.getProficiency().toUpperCase());

        } catch (IllegalArgumentException e) {
            throw new CustomException(ResponseCode.PROFICIENCY_NOT_FOUND);
        }

        pageRequest = PageRequest.of(dto.getPage() - 1, 10);
        List<Float> levels = convertToLevel(proficiency);

        Page<GetProficiencyTheme> proficiencyDataPage
                = menuRepository.findAllByLevelAndStatusOrderByThemeName(
                        pageRequest, proficiency, BaseEntity.Status.ACTIVE, levels, levels.getLast());

        return GetProficiencyThemeListResponse.builder()
                .profName(convertToProfName(proficiency))
                .profDescription(convertToProfDescription(proficiency))
                .proficiencyDataList(PageResponse.from(proficiencyDataPage))
                .build();
    }


    // 장르 기반 방탈출 카페 테마 목록 조회 API
    public PageResponse<GetGenreThemeListResponse> getGenreThemeList(GetGenreThemeListServiceDto dto) {
        pageRequest = PageRequest.of(dto.getPage() - 1, 10);

        Page<GetGenreThemeListResponse> response =
                menuRepository.findThemeByGenre(pageRequest, dto.getGenre(), BaseEntity.Status.ACTIVE);

        return PageResponse.from(response);
    }


    /**
     * 테마 기본 정보 조회 API
     * @return GetReviewThemeInfoResponse
     */
    public GetReviewThemeInfoResponse getReviewThemeInfo(GetThemeInfoServiceDto dto) {
        // 테마 정보가 존재하는지 검사 후 정보를 조회한다
        return menuRepository.findThemeInfoById(dto.getThemeId())
                .orElseThrow(() -> new CustomException(ResponseCode.NOT_FOUND_THEME));
    }

    /**
     * 총평 목록 조회 API
     * @return List<GetOverallReviewListResponse> 총평 목록
     */
    public List<GetOverallReviewListResponse> getOverallReviewList() {
        // 총평 enum을 모두 반환한다
        return Arrays.stream(Constant.Review.values())
                .map(review -> GetOverallReviewListResponse.of(review.getValue(), review))
                .toList();
    }

    /**
     * 지역 목록 조회 API
     * @return List<GetLocationStationListResponse> 지하철역 목록
     */
    public List<GetLocationStationListResponse> getStationList() {
        // DB에 존재하는 지하철역 목록을 모두 반환한다
        return stationRepository.findAll()
                .stream()
                .map(station -> GetLocationStationListResponse.of(station.getId(), station.getName()))
                .toList();
    }

    /**
     * 장르 목록 조회 API
     * @return List<GetGenreListResponse> 장르 목록
     */
    public List<GetGenreListResponse> getGenreList() {
        // 장르 enum을 모두 반환한다
        return Arrays.stream(Constant.Genre.values())
                .map(genre -> GetGenreListResponse.of(genre.getValue(), genre))
                .toList();
    }

    /**
     * 좋아요한 방탈출 목록 조회 API (마이페이지)
     */
    public PageResponse<GetThemeLikedListResponse> getThemeLikedList(GetThemeLikedListServiceDto dto) {
        // 멤버를 조회한다
        Member member = memberService.findEntityById(dto.getMemberId(), BaseEntity.Status.ACTIVE);

        // 사용자가 좋아요 한 방탈출 목록을 조회한다
        PageRequest pageRequest = PageRequest.of(dto.getPage() - 1, 10);
        Page<GetThemeLikedListResponse> response = menuRepository.findLikedThemesByMemberId(member.getId(), dto.getKeyword(), dto.getStationId(), dto.getGenre(), dto.getLevel(), pageRequest);

        return PageResponse.from(response);
    }

    // 방탈출 좋아요를 한다
    @Transactional
    public void createThemeLike(PostThemeLikeServiceDto dto) {
        // member 조회
        Member member = memberService.findEntityById(dto.getMemberId(), BaseEntity.Status.ACTIVE);

        // menu 조회
        Menu menu = findEntityByIdAndStatus(dto.getThemeId(), BaseEntity.Status.ACTIVE);

        // postLike 조회 후, 있다면 예외 발생, 없다면 새로 생성
        if(themeLikeRepository.findByThemeIdAndMemberId(menu.getId(), member.getId()).isPresent())
            throw new CustomException(ResponseCode.EXIST_THEME_LIKE);

        themeLikeRepository.save(ThemeLike.of(menu, member));
    }

    /**
     * 방탈출 좋아요를 취소한다
     */
    @Transactional
    public void deleteThemeLike(DeleteThemeLikeServiceDto dto) {
        // 멤버를 조회한다
        Member member = memberService.findEntityById(dto.getMemberId(), BaseEntity.Status.ACTIVE);

        // 방탈출 테마를 조회하고 방탈출 좋아요가 있는지 확인한다
        Menu menu = findEntityByIdAndStatus(dto.getThemeId(), BaseEntity.Status.ACTIVE);
        Optional<ThemeLike> themeLike = themeLikeRepository.findByThemeIdAndMemberId(menu.getId(), member.getId());

        // 좋아요를 눌렀다면 좋아요를 삭제하고, 누르지 않았다면 예외 처리를 진행한다
        if(themeLike.isPresent()) themeLikeRepository.delete(themeLike.get());
        else throw new CustomException(ResponseCode.INVALID_THEME_LIKE);
    }

    private String convertToProfName(Constant.Proficiency proficiency) {
        return switch (proficiency) {
            case BEGINNER -> "방린이";
            case JUNIOR -> "방초보";
            case SENIOR -> "방준수";
            case MASTER -> "방고인물";
            default -> throw new CustomException(ResponseCode.PROFICIENCY_NOT_FOUND);
        };
    }

    private String convertToProfDescription(Constant.Proficiency proficiency) {
        return switch (proficiency) {
            case BEGINNER -> "방탈출과 초면인 여러분들을 위해 가볍게 즐길 수 있는 테마로 준비했습니다. 대부분 쉽게 탈출할 수 있는 테마들로 구성되었습니다!";
            case JUNIOR -> "방탈출에 입문 중인 여러분들을 방탈출의 세계로 확 빠져들게 하는 테마로 준비했습니다. 몰입감을 줄 수 있는 테마들로 구성되었습니다!";
            case SENIOR -> "어느덧 방탈출에 익숙해진 여러분들을 위해 어느 정도 난이도 있는 테마로 준비했습니다. 볼륨이 큰 테마를 몇 번 해보시면 새로운 재미를 느끼실 수 있을 겁니다!";
            case MASTER -> "어려운 방탈출을 찾는 고수님들을 위해 난이도가 높은 테마로 준비했습니다. 문제를 풀어가는 재미를 느끼실 수 있는 테마들로 구성되었습니다!";
            default -> throw new CustomException(ResponseCode.PROFICIENCY_NOT_FOUND);
        };
    }

    private List<Float> convertToLevel(Constant.Proficiency proficiency) {
        List<Float> level;

        switch (proficiency) {
            case BEGINNER -> level = Arrays.asList(0.0f, 0.5f, 1.0f);
            case JUNIOR -> level = Arrays.asList(1.5f, 2.0f, 2.5f);
            case SENIOR -> level = Arrays.asList(3.0f, 3.5f, 4.0f);
            case MASTER -> level = Arrays.asList(4.0f, 4.5f, 5.0f);
            default -> throw new CustomException(ResponseCode.PROFICIENCY_NOT_FOUND);
        }

        return level;
    }

    public Menu findEntityByIdAndStatus(Long themeId, BaseEntity.Status status) {
        return menuRepository.findByIdAndStatus(themeId, status)
                .orElseThrow(() -> new CustomException(ResponseCode.NOT_FOUND_THEME));
    }
}
