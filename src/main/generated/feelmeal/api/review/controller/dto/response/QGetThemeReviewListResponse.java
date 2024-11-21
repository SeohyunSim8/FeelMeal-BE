package feelmeal.api.review.controller.dto.response;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * feelmeal.api.review.controller.dto.response.QGetThemeReviewListResponse is a Querydsl Projection type for GetThemeReviewListResponse
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QGetThemeReviewListResponse extends ConstructorExpression<GetThemeReviewListResponse> {

    private static final long serialVersionUID = 2133522536L;

    public QGetThemeReviewListResponse(com.querydsl.core.types.Expression<Long> reviewId, com.querydsl.core.types.Expression<String> memberNickname, com.querydsl.core.types.Expression<feelmeal.global.common.entity.Constant.Proficiency> memberProficiency, com.querydsl.core.types.Expression<feelmeal.global.common.entity.Constant.HorrorPos> memberHorrorPos, com.querydsl.core.types.Expression<feelmeal.global.common.entity.Constant.Review> reviewEnum, com.querydsl.core.types.Expression<Float> level, com.querydsl.core.types.Expression<Float> activityLevel, com.querydsl.core.types.Expression<Float> horrorLevel, com.querydsl.core.types.Expression<String> review, com.querydsl.core.types.Expression<Integer> headcount, com.querydsl.core.types.Expression<feelmeal.global.common.entity.Constant.IsEscaped> isEscaped, com.querydsl.core.types.Expression<Integer> usedHint, com.querydsl.core.types.Expression<String> createdAt) {
        super(GetThemeReviewListResponse.class, new Class<?>[]{long.class, String.class, feelmeal.global.common.entity.Constant.Proficiency.class, feelmeal.global.common.entity.Constant.HorrorPos.class, feelmeal.global.common.entity.Constant.Review.class, float.class, float.class, float.class, String.class, int.class, feelmeal.global.common.entity.Constant.IsEscaped.class, int.class, String.class}, reviewId, memberNickname, memberProficiency, memberHorrorPos, reviewEnum, level, activityLevel, horrorLevel, review, headcount, isEscaped, usedHint, createdAt);
    }

}

