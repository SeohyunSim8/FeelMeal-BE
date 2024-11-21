package feelmeal.api.post.controller.dto.response;

import com.querydsl.core.annotations.QueryProjection;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetPostListResponse {
    @Schema(description = "게시물 아이디", example = "1")
    private Long id;

    @Schema(description = "게시물 제목", example = "가나다")
    private String title;

    @Schema(description = "게시물 작성자", example = "아리")
    private String memberName;

    @Schema(description = "게시물 작성일", example = "2024-01-01")
    private String createdAt;

    @Schema(description = "게시물 좋아요 개수", example = "1")
    private Long likeCount;

    @Builder
    @QueryProjection
    public GetPostListResponse(Long id, String title, String memberName, String createdAt, Long likeCount) {
        this.id = id;
        this.title = title;
        this.memberName = memberName;
        this.createdAt = createdAt;
        this.likeCount = likeCount;
    }

    public static GetPostListResponse of(Long id, String title, String memberName, String createdAt, Long likeCount) {
        return GetPostListResponse.builder()
                .id(id)
                .title(title)
                .memberName(memberName)
                .createdAt(createdAt)
                .likeCount(likeCount)
                .build();
    }
}
