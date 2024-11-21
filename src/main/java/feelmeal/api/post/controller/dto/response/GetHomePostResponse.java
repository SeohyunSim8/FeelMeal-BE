package feelmeal.api.post.controller.dto.response;

import com.querydsl.core.annotations.QueryProjection;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetHomePostResponse {
    @Schema(description = "게시물 아이디", example = "1")
    private Long id;

    @Schema(description = "게시물 제목", example = "가나다")
    private String title;

    @Schema(description = "게시물 좋아요 개수", example = "1")
    private Long likeCount;

    @Builder
    @QueryProjection
    public GetHomePostResponse(Long id, String title, Long likeCount) {
        this.id = id;
        this.title = title;
        this.likeCount = likeCount;
    }

    public static GetHomePostResponse of(Long id, String title, Long likeCount) {
        return GetHomePostResponse.builder()
                .id(id)
                .title(title)
                .likeCount(likeCount)
                .build();
    }
}
