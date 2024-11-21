package feelmeal.api.theme.controller.dto.response;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * feelmeal.api.menu.controller.dto.response.QGetProficiencyTheme is a Querydsl Projection type for GetProficiencyTheme
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QGetProficiencyTheme extends ConstructorExpression<GetProficiencyTheme> {

    private static final long serialVersionUID = -400647499L;

    public QGetProficiencyTheme(com.querydsl.core.types.Expression<Long> themeId, com.querydsl.core.types.Expression<String> cityName, com.querydsl.core.types.Expression<String> townName, com.querydsl.core.types.Expression<String> pointName, com.querydsl.core.types.Expression<String> themeName, com.querydsl.core.types.Expression<Float> themeLevel, com.querydsl.core.types.Expression<Integer> themePlayTime, com.querydsl.core.types.Expression<feelmeal.global.common.entity.Constant.Genre> themeGenre) {
        super(GetProficiencyTheme.class, new Class<?>[]{long.class, String.class, String.class, String.class, String.class, float.class, int.class, feelmeal.global.common.entity.Constant.Genre.class}, themeId, cityName, townName, pointName, themeName, themeLevel, themePlayTime, themeGenre);
    }

}

