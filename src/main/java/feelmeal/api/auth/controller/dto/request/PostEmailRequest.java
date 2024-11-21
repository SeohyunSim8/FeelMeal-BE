package feelmeal.api.auth.controller.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import feelmeal.api.auth.service.dto.PostEmailServiceDto;

@Getter
@NoArgsConstructor
public class PostEmailRequest {
    @NotBlank
    @Schema(description = "이메일", example = "feelmeal@gmail.com")
    private String email;

    public PostEmailServiceDto toServiceDto() {
        return PostEmailServiceDto.builder()
                .email(email)
                .build();
    }
}
