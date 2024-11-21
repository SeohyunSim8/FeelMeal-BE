package feelmeal.api.post.controller.dto.response;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * feelmeal.api.post.controller.dto.response.QGetPostResponse is a Querydsl Projection type for GetPostResponse
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QGetPostResponse extends ConstructorExpression<GetPostResponse> {

    private static final long serialVersionUID = 388250625L;

    public QGetPostResponse(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> postType, com.querydsl.core.types.Expression<String> title, com.querydsl.core.types.Expression<String> memberName, com.querydsl.core.types.Expression<String> createdAt, com.querydsl.core.types.Expression<String> content, com.querydsl.core.types.Expression<Long> likeCount, com.querydsl.core.types.Expression<Long> commentCount) {
        super(GetPostResponse.class, new Class<?>[]{long.class, String.class, String.class, String.class, String.class, String.class, long.class, long.class}, id, postType, title, memberName, createdAt, content, likeCount, commentCount);
    }

}

