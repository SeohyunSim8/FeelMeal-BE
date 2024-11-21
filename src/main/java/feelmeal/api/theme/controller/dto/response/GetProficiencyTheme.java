package feelmeal.api.theme.controller.dto.response;

import com.querydsl.core.annotations.QueryProjection;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import feelmeal.global.common.entity.Constant;

@Getter
@NoArgsConstructor
public class GetProficiencyTheme {
    @Schema(description = "테마 아이디", example = "16")
    private Long themeId;

    @Schema(description = "테마 시/도 이름", example = "서울특별시")
    private String cityName;

    @Schema(description = "테마 군/구 이름", example = "마포구")
    private String townName;

    @Schema(description = "테마 지점 이름", example = "키이스케이프 홍대점")
    private String pointName;

    @Schema(description = "테마 이름", example = "삐릿-뽀")
    private String themeName;

    @Schema(description = "테마 난이도", example = "1")
    private Float themeLevel;

    @Schema(description = "테마 플레이타임", example = "60")
    private Integer themePlayTime;

    @Schema(description = "테마 대표장르(SENTIMENTAL: 감성, HORROR: 공포, DETECTIVE: 추리, COMIC: 코믹, MYSTERY: 미스터리, FANTASY: 판타지, ADVENTURE: 어드벤처, ETC: 기타)를 입력해주세요.", example = "FANTASY")
    private Constant.Genre themeGenre;

    @QueryProjection
    @Builder
    public GetProficiencyTheme(Long themeId, String cityName, String townName, String pointName, String themeName, Float themeLevel, Integer themePlayTime, Constant.Genre themeGenre) {
        this.themeId = themeId;
        this.cityName = cityName;
        this.townName = townName;
        this.pointName = pointName;
        this.themeName = themeName;
        this.themeLevel = themeLevel;
        this.themePlayTime = themePlayTime;
        this.themeGenre = themeGenre;
    }

    public static GetProficiencyTheme of(Long themeId, String cityName, String townName, String pointName, String themeName, Float themeLevel, Integer themePlayTime, Constant.Genre themeGenre) {
        return GetProficiencyTheme.builder()
                .themeId(themeId)
                .cityName(cityName)
                .townName(townName)
                .pointName(pointName)
                .themeName(themeName)
                .themeLevel(themeLevel)
                .themePlayTime(themePlayTime)
                .themeGenre(themeGenre)
                .build();
    }
}
