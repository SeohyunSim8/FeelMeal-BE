package feelmeal.api.post.controller.dto.response;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * feelmeal.api.post.controller.dto.response.QGetHomePostResponse is a Querydsl Projection type for GetHomePostResponse
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QGetHomePostResponse extends ConstructorExpression<GetHomePostResponse> {

    private static final long serialVersionUID = 1410838144L;

    public QGetHomePostResponse(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> title, com.querydsl.core.types.Expression<Long> likeCount) {
        super(GetHomePostResponse.class, new Class<?>[]{long.class, String.class, long.class}, id, title, likeCount);
    }

}

