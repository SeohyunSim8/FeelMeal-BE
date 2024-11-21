package feelmeal.api.theme.controller.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import feelmeal.global.common.entity.Constant;

@Getter
@NoArgsConstructor
public class GetOverallReviewListResponse {
    @Schema(description = "총평 (흙길, 풀길, 꽃길, 꽃밭길, 인생테마)", example = "꽃길")
    private String overallReview;

    @Schema(description = "총평 ENUM (SOIL, GRASS, FLOWER, FLOWER_GARDEN, FAVORITE)", example = "FLOWER")
    private Constant.Review overallReviewEnum;

    @Builder
    public GetOverallReviewListResponse(String overallReview, Constant.Review overallReviewEnum) {
        this.overallReview = overallReview;
        this.overallReviewEnum = overallReviewEnum;
    }

    public static GetOverallReviewListResponse of(String overallReview, Constant.Review overallReviewEnum) {
        return GetOverallReviewListResponse.builder()
                .overallReview(overallReview)
                .overallReviewEnum(overallReviewEnum)
                .build();
    }
}
