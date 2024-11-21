package feelmeal.api.member.service.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetReviewMemberServiceDto {
    private Long memberId;

    @Builder
    public GetReviewMemberServiceDto(Long memberId) {
        this.memberId = memberId;
    }

    public static GetReviewMemberServiceDto of(Long memberId) {
        return GetReviewMemberServiceDto.builder()
            .memberId(memberId)
            .build();
    }
}
