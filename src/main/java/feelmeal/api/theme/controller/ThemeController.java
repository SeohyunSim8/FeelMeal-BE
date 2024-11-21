package feelmeal.api.theme.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import feelmeal.api.theme.controller.dto.request.GetUserThemeLikedListRequest;
import feelmeal.api.theme.controller.dto.response.*;
import feelmeal.api.theme.service.ThemeService;
import feelmeal.api.theme.service.dto.*;
import feelmeal.global.annotation.NonAuth;
import feelmeal.global.common.entity.Constant;
import feelmeal.global.common.exception.ErrorResponse;
import feelmeal.global.common.jwt.JwtService;
import feelmeal.global.common.response.PageResponse;

import java.util.List;

import static feelmeal.global.common.exception.ResponseCode.SUCCESS;

@Tag(name = "[Menu]", description = "방탈출 테마 관련 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/themes")
public class ThemeController {
    private final ThemeService themeService;
    private final JwtService jwtService;

    // 위치 기반 방탈출 카페 테마 목록 조회
    @NonAuth
    @Operation(summary = "위치 기반 방탈출 카페 테마 목록 조회 API", description = "위치 기반으로 방탈출 카페의 테마 목록을 조회합니다.")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "요청이 성공적으로 처리되었습니다."),
            @ApiResponse(responseCode = "400", description = "잘못된 요청입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "405", description = "허용되지 않은 메서드입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "내부 서버 오류입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "404", description = "시/도를 찾을 수 없습니다.<br>역을 찾을 수 없습니다.<br>방탈출 카페 지점을 찾을 수 없습니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
    })
    @GetMapping("/home/location")
    public ResponseEntity<PageResponse<GetLocationThemeListResponse>> getLocationThemeList(
            @ParameterObject @NotBlank
            @Schema(description = "검색 카테고리 (**City**: 검색한 시/도 내의 방탈출 카페 지점이 있는 지하철 역 조회, **Station**: 검색한 지하철 역 내의 방탈출 카페 지점 조회, **Restaurant**: 검색한 지점의 테마 조회)를 입력해주세요.", example = "Station")
            String category,
            @ParameterObject @Positive(message = "양수를 입력해주세요.")
            @Schema(description = "값(아이디)을 입력해주세요. (서울의 시/도 아이디: 2)", example = "1")
            Long value,
            @ParameterObject
            @Schema(description = "페이지 번호 (1부터 시작)를 입력해주세요.", example = "1")
            Integer page) {
        PageResponse<GetLocationThemeListResponse> response
                = themeService.getLocationThemeList(GetLocationThemeListServiceDto.of(category, value, page));
        return ResponseEntity.ok(response);
    }

    // 숙련도 기반 방탈출 카페 테마 목록 조회
    @NonAuth
    @Operation(summary = "숙련도 기반 방탈출 카페 테마 목록 조회 API", description = "숙련도 기반으로 방탈출 카페의 테마 목록을 조회합니다.")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "요청이 성공적으로 처리되었습니다."),
            @ApiResponse(responseCode = "400", description = "잘못된 요청입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "405", description = "허용되지 않은 메서드입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "내부 서버 오류입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "404", description = "숙련도를 찾을 수 없습니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping("/home/proficiency")
    public ResponseEntity<GetProficiencyThemeListResponse> getProficiencyThemeList(
            @ParameterObject @NotBlank
            @Schema(description = "숙련도(BEGINNER: 방린이, JUNIOR: 방초보, SENIOR: 방중수, MASTER: 방고인물)를 입력해주세요.", example = "BEGINNER")
            String proficiency,
            @ParameterObject
            @Schema(description = "페이지 번호 (1부터 시작)를 입력해주세요.", example = "1")
            Integer page) {
        GetProficiencyThemeListResponse response
                = themeService.getProficiencyThemeList(GetProficiencyThemeListServiceDto.of(proficiency, page));
        return new ResponseEntity<>(response, SUCCESS.getStatus());
    }

    // 장르 기반 방탈출 카페 테마 목록 조회
    @NonAuth
    @Operation(summary = "장르 기반 방탈출 카페 테마 목록 조회 API", description = "장르 기반으로 방탈출 카페의 테마 목록을 조회합니다.")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "요청이 성공적으로 처리되었습니다."),
            @ApiResponse(responseCode = "400", description = "잘못된 요청입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "405", description = "허용되지 않은 메서드입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "내부 서버 오류입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "404", description = "장르를 찾을 수 없습니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
    })
    @GetMapping("/home/genre")
    public ResponseEntity<PageResponse<GetGenreThemeListResponse>> getGenreData(
            @ParameterObject @NotNull
            @Schema(description = "장르(SENTIMENTAL: 감성, HORROR: 공포, DETECTIVE: 추리, COMIC: 코믹, MYSTERY: 미스터리, FANTASY: 판타지, ADVENTURE: 어드벤처, ETC: 기타)를 입력해주세요.", example = "FANTASY")
            Constant.Genre genre,
            @ParameterObject
            @Schema(description = "페이지 번호 (1부터 시작)를 입력해주세요.", example = "1")
            Integer page) {
        PageResponse<GetGenreThemeListResponse> response
                = themeService.getGenreThemeList(GetGenreThemeListServiceDto.of(genre, page));
        return ResponseEntity.ok(response);
    }

    @NonAuth
    @Operation(summary = "테마 기본 정보 조회 API", description = "테마 기본 정보 조회를 진행한다")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "요청이 성공적으로 처리되었습니다."),
            @ApiResponse(responseCode = "400", description = "잘못된 요청입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "405", description = "허용되지 않은 메서드입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "내부 서버 오류입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "401", description = "유효하지 않은 JWT입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "404", description = "존재하지 않는 유저입니다.<br>" + "존재하지 않는 테마입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping("/{themeId}/review-info")
    public ResponseEntity<GetReviewThemeInfoResponse> getReviewThemeInfo(
            @PathVariable Long themeId
    ) {
        GetReviewThemeInfoResponse response = themeService.getReviewThemeInfo(GetThemeInfoServiceDto.of(themeId));
        return new ResponseEntity<>(response, SUCCESS.getStatus());
    }

    @NonAuth
    @Operation(summary = "총평 목록 조회 API", description = "총평 목록을 조회한다 (중복 사용 가능)")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "요청이 성공적으로 처리되었습니다."),
            @ApiResponse(responseCode = "400", description = "잘못된 요청입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "405", description = "허용되지 않은 메서드입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "내부 서버 오류입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
    })
    @GetMapping("/overall-reviews")
    public ResponseEntity<List<GetOverallReviewListResponse>> getOverallReviewList() {
        // 총평 목록을 조회한다
        List<GetOverallReviewListResponse> response = themeService.getOverallReviewList();
        return new ResponseEntity<>(response, SUCCESS.getStatus());
    }

    @NonAuth
    @Operation(summary = "지역 목록 조회 API", description = "지역 목록을 조회한다 (중복 사용 가능)")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "요청이 성공적으로 처리되었습니다."),
            @ApiResponse(responseCode = "400", description = "잘못된 요청입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "405", description = "허용되지 않은 메서드입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "내부 서버 오류입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
    })
    @GetMapping("/stations")
    public ResponseEntity<List<GetLocationStationListResponse>> getStationList() {
        // 지역 목록을 조회한다
        List<GetLocationStationListResponse> response = themeService.getStationList();
        return new ResponseEntity<>(response, SUCCESS.getStatus());
    }

    @NonAuth
    @Operation(summary = "장르 목록 조회 API", description = "장르 목록을 조회한다 (중복 사용 가능)")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "요청이 성공적으로 처리되었습니다."),
            @ApiResponse(responseCode = "400", description = "잘못된 요청입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "405", description = "허용되지 않은 메서드입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "내부 서버 오류입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
    })
    @GetMapping("/genres")
    public ResponseEntity<List<GetGenreListResponse>> getGenreList() {
        // 장르 목록을 조회한다
        List<GetGenreListResponse> response = themeService.getGenreList();
        return new ResponseEntity<>(response, SUCCESS.getStatus());
    }

    @Operation(summary = "좋아요한 방탈출 목록 조회 API (마이페이지)", description = "마이페이지에서 좋아요한 방탈출 목록 조회를 진행한다 (10개씩 페이징, 페이지는 1부터 시작)")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "요청이 성공적으로 처리되었습니다."),
            @ApiResponse(responseCode = "400", description = "잘못된 요청입니다.<br>" + "JWT를 입력해주세요.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "405", description = "허용되지 않은 메서드입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "내부 서버 오류입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "401", description = "유효하지 않은 JWT입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "404", description = "존재하지 않는 유저입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping("/users/liked-list")
    public ResponseEntity<PageResponse<GetThemeLikedListResponse>> getThemeLikedList(
            @ParameterObject @Valid GetUserThemeLikedListRequest request,
            @ParameterObject Integer page
    ) {
        Long memberId = jwtService.getMemberIdFromUserDetails();
        PageResponse<GetThemeLikedListResponse> response = themeService.getThemeLikedList(request.toServiceDto(memberId, page));
        return new ResponseEntity<>(response, SUCCESS.getStatus());
    }

    // 방탈출 테마 좋아요
    @Operation(summary = "방탈출 좋아요 API", description = "방탈출 좋아요를 합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "요청이 성공적으로 처리되었습니다."),
            @ApiResponse(responseCode = "400", description = "잘못된 요청입니다.<br>" + "JWT를 입력해주세요.<br>" + "이미 좋아요를 한 게시물입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "405", description = "허용되지 않은 메서드입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "내부 서버 오류입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "401", description = "유효하지 않은 JWT입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "404", description = "존재하지 않는 유저입니다.<br>" + "존재하지 않는 방탈출입니다." + "이미 좋아요를 한 방탈출입니다.<br>", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PostMapping("/{themeId}/like")
    public ResponseEntity<String> postThemeLike(
            @PathVariable @Schema(description = "방탈출 테마 아이디를 입력해주세요.", example = "1") Long themeId
    ) {
        themeService.createThemeLike(PostThemeLikeServiceDto.of(jwtService.getMemberIdFromUserDetails(), themeId));
        return new ResponseEntity<>(SUCCESS.getMessage(), SUCCESS.getStatus());
    }

    @Operation(summary = "방탈출 좋아요 취소 API", description = "방탈출 좋아요를 취소한다")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "요청이 성공적으로 처리되었습니다."),
            @ApiResponse(responseCode = "400", description = "잘못된 요청입니다.<br>" + "JWT를 입력해주세요.<br>" + "좋아요하지 않은 방탈출 테마입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "405", description = "허용되지 않은 메서드입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "내부 서버 오류입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "401", description = "유효하지 않은 JWT입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "404", description = "존재하지 않는 유저입니다.<br>" + "존재하지 않는 방탈출입니다.<br>", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @DeleteMapping("/{themeId}/like")
    public ResponseEntity<String> deleteThemeLike(
            @PathVariable Long themeId
    ) {
        Long memberId = jwtService.getMemberIdFromUserDetails();
        themeService.deleteThemeLike(DeleteThemeLikeServiceDto.of(memberId, themeId));
        return new ResponseEntity<>(SUCCESS.getMessage(), SUCCESS.getStatus());
    }
}
