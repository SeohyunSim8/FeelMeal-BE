package feelmeal.api.auth.controller.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostLoginResponse {
    @Schema(description = "멤버 아이디", example = "1")
    private Long memberId;

    @Schema(description = "엑세스 토큰", example = "eyJ0eXBlIjoiand0IiwiYWxnIjoiSFMyNTYifQ.eyJtZW1iZXJJZCI6MSwiaWF0IjoxNzI3NTM3NzI4LCJleHAiOjE3Mjc1NDEzMjh9.YMML0GPtBsW-NtIsZlfLdeY76G5umC57EIgks5mpnu4")
    private String accessToken;

    @Builder
    public PostLoginResponse(Long memberId, String accessToken) {
        this.memberId = memberId;
        this.accessToken = accessToken;
    }

    public static PostLoginResponse of(Long memberId, String accessToken) {
        return PostLoginResponse.builder()
                .memberId(memberId)
                .accessToken(accessToken)
                .build();
    }
}
