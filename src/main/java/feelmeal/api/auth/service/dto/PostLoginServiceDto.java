package feelmeal.api.auth.service.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostLoginServiceDto {
    private String email;

    private String password;

    @Builder
    public PostLoginServiceDto(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
