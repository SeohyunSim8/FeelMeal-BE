package feelmeal.api.auth.service.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import feelmeal.global.common.entity.Constant;

@Getter
@NoArgsConstructor
public class PostSignUpServiceDto {
    private String nickname;

    private String email;

    private String password;

    private Constant.Proficiency proficiency;

    private Constant.HorrorPos horrorPos;

    private Constant.Genre genre;

    private String about;

    @Builder
    public PostSignUpServiceDto(String nickname, String email, String password, Constant.Proficiency proficiency, Constant.HorrorPos horrorPos, Constant.Genre genre, String about) {
        this.nickname = nickname;
        this.email = email;
        this.password = password;
        this.proficiency = proficiency;
        this.horrorPos = horrorPos;
        this.genre = genre;
        this.about = about;
    }
}
