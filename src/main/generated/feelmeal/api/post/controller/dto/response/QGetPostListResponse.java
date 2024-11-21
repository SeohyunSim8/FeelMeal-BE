package feelmeal.api.post.controller.dto.response;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * feelmeal.api.post.controller.dto.response.QGetPostListResponse is a Querydsl Projection type for GetPostListResponse
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QGetPostListResponse extends ConstructorExpression<GetPostListResponse> {

    private static final long serialVersionUID = 157545151L;

    public QGetPostListResponse(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> title, com.querydsl.core.types.Expression<String> memberName, com.querydsl.core.types.Expression<String> createdAt, com.querydsl.core.types.Expression<Long> likeCount) {
        super(GetPostListResponse.class, new Class<?>[]{long.class, String.class, String.class, String.class, long.class}, id, title, memberName, createdAt, likeCount);
    }

}

