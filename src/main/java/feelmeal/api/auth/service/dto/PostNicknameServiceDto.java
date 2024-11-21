package feelmeal.api.auth.service.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostNicknameServiceDto {
    private String nickname;

    @Builder
    public PostNicknameServiceDto(String nickname) {
        this.nickname = nickname;
    }
}
