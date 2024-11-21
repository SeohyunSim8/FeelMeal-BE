package feelmeal.api.theme.controller.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import feelmeal.api.theme.service.dto.GetThemeLikedListServiceDto;
import feelmeal.global.common.entity.Constant;

@Getter
@Setter
@NoArgsConstructor
public class GetUserThemeLikedListRequest {
    @Schema(description = "검색어 (방탈출 테마명)", example = "라스트 잡")
    private String keyword;

    @Schema(description = "역 아이디", example = "1")
    private Long stationId;

    @Schema(description = "장르 (SENTIMENTAL: 감성, HORROR: 공포/스릴러, DETECTIVE: 추리, COMIC: 코믹, MYSTERY: 미스터리, FANTASY: 판타지, ADVENTURE: 어드벤처, ETC: 기타)", example = "SENTIMENTAL")
    private Constant.Genre genre;

    @Min(value = 0, message = "난이도는 최소 0입니다") @Max(value = 5, message = "난이도는 최소 5입니다")
    @Schema(description = "난이도", example = "2.5")
    private Float level;

    public GetThemeLikedListServiceDto toServiceDto(Long memberId, Integer page) {
        return GetThemeLikedListServiceDto.builder()
                .memberId(memberId)
                .page(page)
                .keyword(keyword)
                .stationId(stationId)
                .genre(genre)
                .level(level)
                .build();
    }
}