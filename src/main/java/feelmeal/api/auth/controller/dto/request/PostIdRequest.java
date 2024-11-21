package feelmeal.api.auth.controller.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import feelmeal.api.auth.service.dto.PostNicknameServiceDto;

@Getter
@NoArgsConstructor
public class PostIdRequest {
    @NotBlank
    @Schema(description = "닉네임", example = "보리")
    private String nickname;

    public PostNicknameServiceDto toServiceDto() {
        return PostNicknameServiceDto.builder()
                .nickname(nickname)
                .build();
    }
}
