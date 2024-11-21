package feelmeal.api.d.controller.dto.response;

import com.querydsl.core.annotations.QueryProjection;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetThemeLikedListResponse {
    @Schema(description = "테마 아이디", example = "1")
    private Long themeId;

    @Schema(description = "지점 이름", example = "비밀의 화원 포레스트 건대")
    private String point;

    @Schema(description = "테마 이름", example = "라스트 잡")
    private String theme;

    @Schema(description = "난이도", example = "2.5")
    private Float level;

    @Schema(description = "지역 (역)", example = "건대")
    private String station;

    @Builder
    @QueryProjection
    public GetThemeLikedListResponse(Long themeId, String point, String theme, Float level, String station) {
        this.themeId = themeId;
        this.point = point;
        this.theme = theme;
        this.level = level;
        this.station = station;
    }

    public static GetThemeLikedListResponse of(Long themeId, String point, String theme, Float level, String station) {
        return GetThemeLikedListResponse.builder()
                .themeId(themeId)
                .point(point)
                .theme(theme)
                .level(level)
                .station(station)
                .build();
    }
}