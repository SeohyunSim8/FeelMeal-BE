package feelmeal.api.post.service.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetPostCommentListServiceDto {
    private Integer page;
    private Long postId;

    @Builder
    public GetPostCommentListServiceDto(Integer page, Long postId) {
        this.page = page;
        this.postId = postId;
    }

    public static GetPostCommentListServiceDto of (Integer page, Long postId) {
        return GetPostCommentListServiceDto.builder()
                .page(page)
                .postId(postId)
                .build();
    }
}