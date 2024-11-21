package feelmeal.api.auth.controller.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import feelmeal.api.auth.service.dto.PostLoginServiceDto;

@Getter
@NoArgsConstructor
public class PostLoginRequest {
    @NotBlank
    @Email
    @Schema(description = "이메일", example = "feelmeal@gmail.com")
    private String email;

    @NotBlank
    @Schema(description = "비밀번호", example = "1234")
    private String password;

    public PostLoginServiceDto toServiceDto() {
        return PostLoginServiceDto.builder()
                .email(email)
                .password(password)
                .build();
    }
}
