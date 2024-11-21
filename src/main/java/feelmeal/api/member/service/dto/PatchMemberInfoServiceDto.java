package feelmeal.api.member.service.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import feelmeal.global.common.entity.Constant;

@Getter
@NoArgsConstructor
public class PatchMemberInfoServiceDto {
    private Long memberId;

    private String nickname;

    private String email;

    private String password;

    private Constant.Proficiency proficiency;

    private Constant.HorrorPos horrorPos;

    private Constant.Genre genre;

    private String about;

    @Builder
    public PatchMemberInfoServiceDto(Long memberId, String nickname, String email, String password, Constant.Proficiency proficiency, Constant.HorrorPos horrorPos, Constant.Genre genre, String about) {
        this.memberId = memberId;
        this.nickname = nickname;
        this.email = email;
        this.password = password;
        this.proficiency = proficiency;
        this.horrorPos = horrorPos;
        this.genre = genre;
        this.about = about;
    }

    public void encryptPassword(String password) {
        this.password = password;
    }
}
