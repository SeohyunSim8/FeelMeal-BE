package feelmeal.domain.review.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QThemeReviewParticipant is a Querydsl query type for ThemeReviewParticipant
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QThemeReviewParticipant extends EntityPathBase<ThemeReviewParticipant> {

    private static final long serialVersionUID = -1675114687L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QThemeReviewParticipant themeReviewParticipant = new QThemeReviewParticipant("themeReviewParticipant");

    public final StringPath content = createString("content");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final EnumPath<feelmeal.global.common.entity.Constant.Proficiency> proficiency = createEnum("proficiency", feelmeal.global.common.entity.Constant.Proficiency.class);

    public final QThemeReview review;

    public QThemeReviewParticipant(String variable) {
        this(ThemeReviewParticipant.class, forVariable(variable), INITS);
    }

    public QThemeReviewParticipant(Path<? extends ThemeReviewParticipant> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QThemeReviewParticipant(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QThemeReviewParticipant(PathMetadata metadata, PathInits inits) {
        this(ThemeReviewParticipant.class, metadata, inits);
    }

    public QThemeReviewParticipant(Class<? extends ThemeReviewParticipant> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.review = inits.isInitialized("review") ? new QThemeReview(forProperty("review"), inits.get("review")) : null;
    }

}

