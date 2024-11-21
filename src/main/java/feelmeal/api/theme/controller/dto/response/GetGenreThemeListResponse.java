package feelmeal.api.theme.controller.dto.response;

import com.querydsl.core.annotations.QueryProjection;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import feelmeal.global.common.entity.Constant;

@Getter
@NoArgsConstructor
public class GetGenreThemeListResponse {
    @Schema(description = "테마 아이디", example = "16")
    private Long id;

    @Schema(description = "역 이름", example = "홍대입구")
    private String stationName;

    @Schema(description = "지점 이름", example = "키이스케이프 홍대점")
    private String pointName;

    @Schema(description = "테마 이름", example = "삐릿-뽀")
    private String name;

    @Schema(description = "테마 난이도", example = "1")
    private Float themeLevel;

    @Schema(description = "테마 플레이타임", example = "60")
    private Integer themePlayTime;

    @Schema(description = "테마 대표장르(SENTIMENTAL: 감성, HORROR: 공포, DETECTIVE: 추리, COMIC: 코믹, MYSTERY: 미스터리, FANTASY: 판타지, ADVENTURE: 어드벤처, ETC: 기타)를 입력해주세요.", example = "FANTASY")
    private Constant.Genre themeGenre;

    @Schema(description = "테마 사진", example = "https://i.postimg.cc/8zv36BDh/theme.jpg")
    private String img;

    @Builder
    @QueryProjection
    public GetGenreThemeListResponse(Long id, String stationName, String pointName, String name, Float themeLevel, Integer themePlayTime, Constant.Genre themeGenre, String img) {
        this.id = id;
        this.stationName = stationName;
        this.pointName = pointName;
        this.name = name;
        this.themeLevel = themeLevel;
        this.themePlayTime = themePlayTime;
        this.themeGenre = themeGenre;
        this.img = img;
    }

    public static GetGenreThemeListResponse of(Long id, String stationName, String pointName, String name, Float themeLevel, Integer themePlayTime, Constant.Genre themeGenre, String img) {
        return GetGenreThemeListResponse.builder()
                .id(id)
                .stationName(stationName)
                .pointName(pointName)
                .name(name)
                .themeLevel(themeLevel)
                .themePlayTime(themePlayTime)
                .themeGenre(themeGenre)
                .img(img)
                .build();
    }
}
