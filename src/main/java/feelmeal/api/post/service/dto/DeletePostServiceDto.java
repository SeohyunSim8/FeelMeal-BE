package feelmeal.api.post.service.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DeletePostServiceDto {
    private Long memberId;
    private Long postId;

    @Builder
    public DeletePostServiceDto(Long memberId, Long postId) {
        this.memberId = memberId;
        this.postId = postId;
    }

    public static DeletePostServiceDto of (Long memberId, Long postId) {
        return DeletePostServiceDto.builder()
                .memberId(memberId)
                .postId(postId)
                .build();
    }
}