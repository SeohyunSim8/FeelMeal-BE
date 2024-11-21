package feelmeal.api.booking.controller.dto.response;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * feelmeal.api.booking.controller.dto.response.QGetReserveThemeListResponse is a Querydsl Projection type for GetReserveThemeListResponse
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QGetReserveThemeListResponse extends ConstructorExpression<GetReserveThemeListResponse> {

    private static final long serialVersionUID = 332687613L;

    public QGetReserveThemeListResponse(com.querydsl.core.types.Expression<Long> reserveId, com.querydsl.core.types.Expression<String> reserveDate, com.querydsl.core.types.Expression<String> reserveTime, com.querydsl.core.types.Expression<String> point, com.querydsl.core.types.Expression<String> theme) {
        super(GetReserveThemeListResponse.class, new Class<?>[]{long.class, String.class, String.class, String.class, String.class}, reserveId, reserveDate, reserveTime, point, theme);
    }

}

