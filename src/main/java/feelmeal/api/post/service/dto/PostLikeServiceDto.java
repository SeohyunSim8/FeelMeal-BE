package feelmeal.api.post.service.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostLikeServiceDto {
    private Long memberId;
    private Long postId;

    @Builder
    public PostLikeServiceDto(Long memberId, Long postId) {
        this.memberId = memberId;
        this.postId = postId;
    }

    public static PostLikeServiceDto of (Long memberId, Long postId) {
        return PostLikeServiceDto.builder()
                .memberId(memberId)
                .postId(postId)
                .build();
    }
}