package feelmeal.api.review.controller.dto.response;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * feelmeal.api.review.controller.dto.response.QGetThemeReviewParticipantResponse is a Querydsl Projection type for GetThemeReviewParticipantResponse
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QGetThemeReviewParticipantResponse extends ConstructorExpression<GetThemeReviewParticipantResponse> {

    private static final long serialVersionUID = 2001927947L;

    public QGetThemeReviewParticipantResponse(com.querydsl.core.types.Expression<feelmeal.global.common.entity.Constant.Proficiency> proficiency, com.querydsl.core.types.Expression<Integer> participantCnt) {
        super(GetThemeReviewParticipantResponse.class, new Class<?>[]{feelmeal.global.common.entity.Constant.Proficiency.class, int.class}, proficiency, participantCnt);
    }

}

