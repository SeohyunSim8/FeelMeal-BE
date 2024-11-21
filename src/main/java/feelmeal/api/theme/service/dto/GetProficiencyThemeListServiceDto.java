package feelmeal.api.theme.service.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetProficiencyThemeListServiceDto {
    private String proficiency;
    private Integer page;

    @Builder
    public GetProficiencyThemeListServiceDto(String proficiency, Integer page) {
        this.proficiency = proficiency;
        this.page = page;
    }

    public static GetProficiencyThemeListServiceDto of(String proficiency, Integer page) {
        return GetProficiencyThemeListServiceDto.builder()
                .proficiency(proficiency)
                .page(page)
                .build();
    }
}