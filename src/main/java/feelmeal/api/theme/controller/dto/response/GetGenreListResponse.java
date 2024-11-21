package feelmeal.api.theme.controller.dto.response;

import feelmeal.global.common.entity.Constant;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetGenreListResponse {
    @Schema(description = "장르 (감성, 공포, 추리, 코믹, 미스터리, 판타지,어드벤처, 기타)", example = "감성")
    private String genre;

    @Schema(description = "장르 ENUM (SENTIMENTAL: 감성, HORROR: 공포, DETECTIVE: 추리, COMIC: 코믹, MYSTERY: 미스터리, FANTASY: 판타지, ADVENTURE: 어드벤처, ETC: 기타", example = "SENTIMENTAL")
    private Constant.Genre genreEnum;

    @Builder
    public GetGenreListResponse(String genre, Constant.Genre genreEnum) {
        this.genre = genre;
        this.genreEnum = genreEnum;
    }

    public static GetGenreListResponse of(String genre, Constant.Genre genreEnum) {
        return GetGenreListResponse.builder()
                .genre(genre)
                .genreEnum(genreEnum)
                .build();
    }
}
