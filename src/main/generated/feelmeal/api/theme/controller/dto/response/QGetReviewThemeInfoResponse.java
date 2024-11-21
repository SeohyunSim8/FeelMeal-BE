package feelmeal.api.theme.controller.dto.response;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * feelmeal.api.menu.controller.dto.response.QGetReviewThemeInfoResponse is a Querydsl Projection type for GetReviewThemeInfoResponse
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QGetReviewThemeInfoResponse extends ConstructorExpression<GetReviewThemeInfoResponse> {

    private static final long serialVersionUID = 2088903551L;

    public QGetReviewThemeInfoResponse(com.querydsl.core.types.Expression<Long> themeId, com.querydsl.core.types.Expression<String> point, com.querydsl.core.types.Expression<String> theme, com.querydsl.core.types.Expression<String> themeImg, com.querydsl.core.types.Expression<? extends java.util.List<String>> genreList, com.querydsl.core.types.Expression<Integer> playTime, com.querydsl.core.types.Expression<Float> level, com.querydsl.core.types.Expression<String> synopsis) {
        super(GetReviewThemeInfoResponse.class, new Class<?>[]{long.class, String.class, String.class, String.class, java.util.List.class, int.class, float.class, String.class}, themeId, point, theme, themeImg, genreList, playTime, level, synopsis);
    }

}

