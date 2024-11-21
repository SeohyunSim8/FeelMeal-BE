package feelmeal.api.review.controller.dto.response;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * feelmeal.api.review.controller.dto.response.QGetThemeReviewResponse is a Querydsl Projection type for GetThemeReviewResponse
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QGetThemeReviewResponse extends ConstructorExpression<GetThemeReviewResponse> {

    private static final long serialVersionUID = 328891946L;

    public QGetThemeReviewResponse(com.querydsl.core.types.Expression<Long> reviewId, com.querydsl.core.types.Expression<Long> themeId, com.querydsl.core.types.Expression<Long> memberId, com.querydsl.core.types.Expression<String> playedAt, com.querydsl.core.types.Expression<? extends java.util.List<GetThemeReviewParticipantResponse>> participantList, com.querydsl.core.types.Expression<Boolean> hasEscape, com.querydsl.core.types.Expression<feelmeal.global.common.entity.Constant.FailReason> failReason, com.querydsl.core.types.Expression<String> leftTime, com.querydsl.core.types.Expression<Integer> usedHint, com.querydsl.core.types.Expression<Float> level, com.querydsl.core.types.Expression<String> levelInfo, com.querydsl.core.types.Expression<Integer> lockRatio, com.querydsl.core.types.Expression<String> lockRatioInfo, com.querydsl.core.types.Expression<Float> horrorLevel, com.querydsl.core.types.Expression<String> horrorInfo, com.querydsl.core.types.Expression<Float> activityLevel, com.querydsl.core.types.Expression<String> activityInfo, com.querydsl.core.types.Expression<feelmeal.global.common.entity.Constant.Clothes> clothes, com.querydsl.core.types.Expression<Float> storyLevel, com.querydsl.core.types.Expression<String> storyInfo, com.querydsl.core.types.Expression<Float> interiorLevel, com.querydsl.core.types.Expression<String> interiorInfo, com.querydsl.core.types.Expression<feelmeal.global.common.entity.Constant.Review> overallReview, com.querydsl.core.types.Expression<String> review, com.querydsl.core.types.Expression<? extends java.util.List<feelmeal.global.common.entity.Constant.ThemeReviewTag>> reviewTagList) {
        super(GetThemeReviewResponse.class, new Class<?>[]{long.class, long.class, long.class, String.class, java.util.List.class, boolean.class, feelmeal.global.common.entity.Constant.FailReason.class, String.class, int.class, float.class, String.class, int.class, String.class, float.class, String.class, float.class, String.class, feelmeal.global.common.entity.Constant.Clothes.class, float.class, String.class, float.class, String.class, feelmeal.global.common.entity.Constant.Review.class, String.class, java.util.List.class}, reviewId, themeId, memberId, playedAt, participantList, hasEscape, failReason, leftTime, usedHint, level, levelInfo, lockRatio, lockRatioInfo, horrorLevel, horrorInfo, activityLevel, activityInfo, clothes, storyLevel, storyInfo, interiorLevel, interiorInfo, overallReview, review, reviewTagList);
    }

}

