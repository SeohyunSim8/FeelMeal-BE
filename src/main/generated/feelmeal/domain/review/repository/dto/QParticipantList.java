package feelmeal.domain.review.repository.dto;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * feelmeal.domain.review.repository.dto.QParticipantList is a Querydsl Projection type for ParticipantList
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QParticipantList extends ConstructorExpression<ParticipantList> {

    private static final long serialVersionUID = 1432312154L;

    public QParticipantList(com.querydsl.core.types.Expression<Long> reviewId, com.querydsl.core.types.Expression<feelmeal.global.common.entity.Constant.Proficiency> proficiency, com.querydsl.core.types.Expression<Integer> participantCnt) {
        super(ParticipantList.class, new Class<?>[]{long.class, feelmeal.global.common.entity.Constant.Proficiency.class, int.class}, reviewId, proficiency, participantCnt);
    }

}

