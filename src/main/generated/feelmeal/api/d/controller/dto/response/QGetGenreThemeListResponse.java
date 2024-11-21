package feelmeal.api.d.controller.dto.response;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * feelmeal.api.d.controller.dto.response.QGetGenreThemeListResponse is a Querydsl Projection type for GetGenreThemeListResponse
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QGetGenreThemeListResponse extends ConstructorExpression<GetGenreThemeListResponse> {

    private static final long serialVersionUID = -1444520495L;

    public QGetGenreThemeListResponse(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> stationName, com.querydsl.core.types.Expression<String> pointName, com.querydsl.core.types.Expression<String> name, com.querydsl.core.types.Expression<Float> themeLevel, com.querydsl.core.types.Expression<Integer> themePlayTime, com.querydsl.core.types.Expression<? extends feelmeal.global.common.entity.Constant.Genre> themeGenre, com.querydsl.core.types.Expression<String> img) {
        super(GetGenreThemeListResponse.class, new Class<?>[]{long.class, String.class, String.class, String.class, float.class, int.class, feelmeal.global.common.entity.Constant.Genre.class, String.class}, id, stationName, pointName, name, themeLevel, themePlayTime, themeGenre, img);
    }

}

