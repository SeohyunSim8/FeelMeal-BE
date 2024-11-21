package feelmeal.api.post.controller.dto.response;

import com.querydsl.core.annotations.QueryProjection;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetCommentListResponse {
    @Schema(description = "댓글 아이디", example = "1")
    private Long id;

    @Schema(description = "댓글 작성자", example = "아리")
    private String memberName;

    @Schema(description = "댓글 작성일시", example = "2024-01-01 09:00")
    private String createdAt;

    @Schema(description = "댓글 본문", example = "가나다")
    private String content;

    @Builder
    @QueryProjection
    public GetCommentListResponse(Long id, String memberName, String createdAt, String content) {
        this.id = id;
        this.memberName = memberName;
        this.createdAt = createdAt;
        this.content = content;
    }

    public static GetCommentListResponse of(Long id, String memberName, String createdAt, String content) {
        return GetCommentListResponse.builder()
                .id(id)
                .memberName(memberName)
                .createdAt(createdAt)
                .content(content)
                .build();
    }
}
