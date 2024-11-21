package feelmeal.api.member.controller.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetMemberInfoResponse {
    @Schema(description = "멤버 아이디", example = "1")
    private Long memberId;

    @Schema(description = "닉네임", example = "보리")
    private String nickname;

    @Schema(description = "이메일", example = "feelmeal@gmail.com")
    private String email;

    @Schema(description = "프로필 사진", example = "")
    private String profileImg;

    @Builder
    public GetMemberInfoResponse(Long memberId, String nickname, String email, String profileImg) {
        this.memberId = memberId;
        this.nickname = nickname;
        this.email = email;
        this.profileImg = profileImg;
    }

    public static GetMemberInfoResponse of(Long memberId, String nickname, String email, String profileImg) {
        return GetMemberInfoResponse.builder()
                .memberId(memberId)
                .nickname(nickname)
                .email(email)
                .profileImg(profileImg)
                .build();
    }
}
