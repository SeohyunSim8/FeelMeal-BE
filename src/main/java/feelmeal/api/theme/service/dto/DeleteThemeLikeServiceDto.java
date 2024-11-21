package feelmeal.api.theme.service.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DeleteThemeLikeServiceDto {
    private Long memberId;

    private Long themeId;

    @Builder
    public DeleteThemeLikeServiceDto(Long memberId, Long themeId) {
        this.memberId = memberId;
        this.themeId = themeId;
    }

    public static DeleteThemeLikeServiceDto of(Long memberId, Long themeId) {
        return DeleteThemeLikeServiceDto.builder()
                .memberId(memberId)
                .themeId(themeId)
                .build();
    }
}
