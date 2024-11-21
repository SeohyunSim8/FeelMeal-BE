package feelmeal.api.theme.service.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetThemeInfoServiceDto {
    private Long themeId;

    @Builder
    public GetThemeInfoServiceDto(Long themeId) {
        this.themeId = themeId;
    }

    public static GetThemeInfoServiceDto of(Long themeId) {
        return GetThemeInfoServiceDto.builder()
                .themeId(themeId)
                .build();
    }
}
