package feelmeal.api.post.service.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetPostServiceDto {
    private Long postId;

    @Builder
    public GetPostServiceDto(Long postId) {
        this.postId = postId;
    }

    public static GetPostServiceDto of (Long postId) {
        return GetPostServiceDto.builder()
                .postId(postId)
                .build();
    }
}