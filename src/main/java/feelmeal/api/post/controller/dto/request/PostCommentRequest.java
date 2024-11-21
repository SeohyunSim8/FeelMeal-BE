package feelmeal.api.post.controller.dto.request;

import feelmeal.api.post.service.dto.PostCommentServiceDto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostCommentRequest {
    @NotBlank @Size(max = 1000, message = "최대 1000자 입력할 수 있습니다.")
    @Schema(description = "댓글 내용", example = "가나다라마")
    private String content;

    public PostCommentServiceDto toServiceDto(Long memberId, Long postId) {
        return PostCommentServiceDto.builder()
                .memberId(memberId)
                .postId(postId)
                .content(content)
                .build();
    }
}