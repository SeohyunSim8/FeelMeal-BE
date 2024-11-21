package feelmeal.api.theme.service.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import feelmeal.global.common.entity.Constant;

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