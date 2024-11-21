package feelmeal.api.d.controller.dto.response;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * feelmeal.api.d.controller.dto.response.QGetThemeLikedListResponse is a Querydsl Projection type for GetThemeLikedListResponse
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QGetThemeLikedListResponse extends ConstructorExpression<GetThemeLikedListResponse> {

    private static final long serialVersionUID = -177381841L;

    public QGetThemeLikedListResponse(com.querydsl.core.types.Expression<Long> themeId, com.querydsl.core.types.Expression<String> point, com.querydsl.core.types.Expression<String> theme, com.querydsl.core.types.Expression<Float> level, com.querydsl.core.types.Expression<String> station) {
        super(GetThemeLikedListResponse.class, new Class<?>[]{long.class, String.class, String.class, float.class, String.class}, themeId, point, theme, level, station);
    }

}

