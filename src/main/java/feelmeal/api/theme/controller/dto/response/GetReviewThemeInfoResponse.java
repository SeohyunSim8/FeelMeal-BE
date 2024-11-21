package feelmeal.api.theme.controller.dto.response;

import com.querydsl.core.annotations.QueryProjection;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class GetReviewThemeInfoResponse {
    @Schema(description = "테마 아이디", example = "1")
    private Long themeId;

    @Schema(description = "지점 이름", example = "키이스케이프 메모리컴퍼니")
    private String point;

    @Schema(description = "테마 이름", example = "필름 바이 스티브")
    private String theme;

    @Schema(description = "테마 이미지")
    private String themeImg;

    @Schema(description = "장르 목록")
    private List<String> genreList;

    @Schema(description = "플레이 시간", example = "80")
    private int playTime;

    @Schema(description = "공식 난이도", example = "2.5")
    private Float level;

    @Schema(description = "시놉시스", example = "메모리 컴퍼니 투어 프로그램을 꼭 체험해 보고 싶습니다 ... ")
    private String synopsis;

    @Builder
    @QueryProjection
    public GetReviewThemeInfoResponse(Long themeId, String point, String theme, String themeImg, List<String> genreList, int playTime, Float level, String synopsis) {
        this.themeId = themeId;
        this.point = point;
        this.theme = theme;
        this.themeImg = themeImg;
        this.genreList = genreList;
        this.playTime = playTime;
        this.level = level;
        this.synopsis = synopsis;
    }

    public static GetReviewThemeInfoResponse of(Long themeId, String point, String theme, String themeImg, List<String> genreList, int playTime, Float level, String synopsis) {
        return GetReviewThemeInfoResponse.builder()
                .themeId(themeId)
                .point(point)
                .theme(theme)
                .themeImg(themeImg)
                .genreList(genreList)
                .playTime(playTime)
                .level(level)
                .synopsis(synopsis)
                .build();
    }
}