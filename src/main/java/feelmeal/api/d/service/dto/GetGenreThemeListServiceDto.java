package feelmeal.api.d.service.dto;

import feelmeal.global.common.entity.Constant;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetGenreThemeListServiceDto {
    private Constant.Genre genre;
    private Integer page;

    @Builder
    public GetGenreThemeListServiceDto(Constant.Genre genre, Integer page) {
        this.genre = genre;
        this.page = page;
    }

    public static GetGenreThemeListServiceDto of(Constant.Genre genre, Integer page) {
        return GetGenreThemeListServiceDto.builder()
                .genre(genre)
                .page(page)
                .build();
    }
}