package feelmeal.api.post.controller.dto.response;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * feelmeal.api.post.controller.dto.response.QGetCommentListResponse is a Querydsl Projection type for GetCommentListResponse
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QGetCommentListResponse extends ConstructorExpression<GetCommentListResponse> {

    private static final long serialVersionUID = -824392823L;

    public QGetCommentListResponse(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> memberName, com.querydsl.core.types.Expression<String> createdAt, com.querydsl.core.types.Expression<String> content) {
        super(GetCommentListResponse.class, new Class<?>[]{long.class, String.class, String.class, String.class}, id, memberName, createdAt, content);
    }

}

