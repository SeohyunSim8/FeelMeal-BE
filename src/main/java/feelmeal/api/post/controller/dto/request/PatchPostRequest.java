package feelmeal.api.post.controller.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import feelmeal.api.post.service.dto.PatchPostServiceDto;
import feelmeal.global.common.entity.Constant;

@Getter
@Setter
@NoArgsConstructor
public class PatchPostRequest {
    @NotNull
    @Schema(description = "게시판 타입 (THEME: 인생테마, QUESTION: 질문)", example = "THEME")
    private Constant.PostType postType;

    @NotBlank @Size(max = 100, message = "최대 100자 입력할 수 있습니다.")
    @Schema(description = "게시물 제목", example = "가나다")
    private String title;

    @NotBlank @Size(max = 5000, message = "최대 5000자 입력할 수 있습니다.")
    @Schema(description = "게시물 내용", example = "가나다라마")
    private String content;

    public PatchPostServiceDto toServiceDto(Long memberId, Long postId) {
        return PatchPostServiceDto.builder()
                .memberId(memberId)
                .postId(postId)
                .postType(postType)
                .title(title)
                .content(content)
                .build();
    }
}