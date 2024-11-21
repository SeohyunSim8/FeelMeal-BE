package feelmeal.api.auth.controller.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import feelmeal.api.auth.service.dto.PostSignUpServiceDto;
import feelmeal.global.common.entity.Constant;

@Getter
@NoArgsConstructor
public class PostSignUpRequest {
    @NotBlank
    @Schema(description = "아이디", example = "abc12")
    private String id;

    @Pattern(regexp = "^[a-zA-Z0-9]+$")
    @NotBlank
    @Schema(description = "비밀번호", example = "1234")
    private String password;

    @NotBlank
    @Schema(description = "이름", example = "심서현")
    private String name;

    @NotBlank
    @Schema(description = "주소", example = "복정동 495")
    private String address;

    public PostSignUpServiceDto toServiceDto() {
        return PostSignUpServiceDto.builder()
                .nickname(nickname)
                .email(email)
                .password(password)
                .proficiency(proficiency)
                .horrorPos(horrorPos)
                .genre(genre)
                .about(about)
                .build();
    }
}
