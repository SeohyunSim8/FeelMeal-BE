package feelmeal.api.post.controller.dto.response;

import com.querydsl.core.annotations.QueryProjection;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetPostResponse {
    @Schema(description = "게시물 아이디", example = "1")
    private Long id;

    @Schema(description = "게시물 타입", example = "인생테마")
    private String postType;

    @Schema(description = "게시물 작성자", example = "아리")
    private String memberName;

    @Schema(description = "게시물 작성일시", example = "2024-01-01 09:00")
    private String createdAt;

    @Schema(description = "게시물 제목", example = "가나다")
    private String title;

    @Schema(description = "게시물 본문", example = "가나다")
    private String content;

    @Schema(description = "게시물 좋아요 개수", example = "1")
    private Long likeCount;

    @Schema(description = "댓글 갯수", example = "1")
    private Long commentCount;

    @Builder
    @QueryProjection
    public GetPostResponse(Long id, String postType, String title, String memberName, String createdAt, String content,
                           Long likeCount, Long commentCount) {
        this.id = id;
        this.postType = postType;
        this.title = title;
        this.memberName = memberName;
        this.createdAt = createdAt;
        this.content = content;
        this.likeCount = likeCount;
        this.commentCount = commentCount;
    }

    public static GetPostResponse of(Long id, String postType, String title, String memberName, String createdAt,
                                     String content, Long likeCount, Long commentCount) {
        return GetPostResponse.builder()
                .id(id)
                .postType(postType)
                .title(title)
                .memberName(memberName)
                .createdAt(createdAt)
                .content(content)
                .likeCount(likeCount)
                .commentCount(commentCount)
                .build();
    }
}
