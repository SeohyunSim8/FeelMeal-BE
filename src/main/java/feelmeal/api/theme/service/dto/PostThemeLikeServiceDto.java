package feelmeal.api.theme.service.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostThemeLikeServiceDto {
    private Long memberId;
    private Long themeId;

    @Builder
    public PostThemeLikeServiceDto(Long memberId, Long themeId) {
        this.memberId = memberId;
        this.themeId = themeId;
    }

    public static PostThemeLikeServiceDto of(Long memberId, Long themeId) {
        return PostThemeLikeServiceDto.builder()
                .memberId(memberId)
                .themeId(themeId)
                .build();
    }
}
