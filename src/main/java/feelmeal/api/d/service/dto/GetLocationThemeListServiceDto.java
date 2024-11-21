package feelmeal.api.d.service.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetLocationThemeListServiceDto {
    private String category;
    private Long value;
    private Integer page;

    @Builder
    public GetLocationThemeListServiceDto(String category, Long value, Integer page) {
        this.category = category;
        this.value = value;
        this.page = page;
    }

    public static GetLocationThemeListServiceDto of(String category, Long value, Integer page) {
        return GetLocationThemeListServiceDto.builder()
                .category(category)
                .value(value)
                .page(page)
                .build();
    }
}