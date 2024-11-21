package feelmeal.api.member.service.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetMemberServiceDto {
    private Long memberId;

    @Builder
    public GetMemberServiceDto(Long memberId) {
        this.memberId = memberId;
    }

    public static GetMemberServiceDto of(Long memberId) {
        return GetMemberServiceDto.builder()
            .memberId(memberId)
            .build();
    }
}
