package feelmeal.api.post.controller.dto.request;

import feelmeal.api.post.service.dto.PatchCommentServiceDto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PatchCommentRequest {
    @NotBlank @Size(max = 1000, message = "최대 1000자 입력할 수 있습니다.")
    @Schema(description = "댓글 내용", example = "가나다라마")
    private String content;

    public PatchCommentServiceDto toServiceDto(Long memberId, Long postId, Long commentId) {
        return PatchCommentServiceDto.builder()
                .memberId(memberId)
                .postId(postId)
                .commentId(commentId)
                .content(content)
                .build();
    }
}