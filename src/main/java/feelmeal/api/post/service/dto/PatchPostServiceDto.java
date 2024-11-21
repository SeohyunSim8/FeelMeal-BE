package feelmeal.api.post.service.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import feelmeal.global.common.entity.Constant;

@Getter
@Setter
@NoArgsConstructor
public class PatchPostServiceDto {
    private Long memberId;
    private Long postId;
    private Constant.PostType postType;
    private String title;
    private String content;

    @Builder
    public PatchPostServiceDto(Long memberId, Long postId, Constant.PostType postType, String title, String content) {
        this.memberId = memberId;
        this.postId = postId;
        this.postType = postType;
        this.title = title;
        this.content = content;
    }
}