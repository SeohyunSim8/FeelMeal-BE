package feelmeal.api.post.service.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import feelmeal.global.common.entity.Constant;

@Getter
@Setter
@NoArgsConstructor
public class PostPostServiceDto {
    private Long memberId;
    private Constant.PostType postType;
    private String title;
    private String content;

    @Builder
    public PostPostServiceDto(Long memberId, Constant.PostType postType, String title, String content) {
        this.memberId = memberId;
        this.postType = postType;
        this.title = title;
        this.content = content;
    }
}