package feelmeal.api.review.controller.dto.response;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * feelmeal.api.review.controller.dto.response.QGetUserThemeReviewListResponse is a Querydsl Projection type for GetUserThemeReviewListResponse
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QGetUserThemeReviewListResponse extends ConstructorExpression<GetUserThemeReviewListResponse> {

    private static final long serialVersionUID = 242314269L;

    public QGetUserThemeReviewListResponse(com.querydsl.core.types.Expression<Long> reviewId, com.querydsl.core.types.Expression<String> point, com.querydsl.core.types.Expression<String> theme, com.querydsl.core.types.Expression<String> date, com.querydsl.core.types.Expression<feelmeal.global.common.entity.Constant.Review> overallReview, com.querydsl.core.types.Expression<Boolean> hasEscape) {
        super(GetUserThemeReviewListResponse.class, new Class<?>[]{long.class, String.class, String.class, String.class, feelmeal.global.common.entity.Constant.Review.class, boolean.class}, reviewId, point, theme, date, overallReview, hasEscape);
    }

}

