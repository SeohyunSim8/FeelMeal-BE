package feelmeal.domain.review.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QThemeReviewTag is a Querydsl query type for ThemeReviewTag
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QThemeReviewTag extends EntityPathBase<ThemeReviewTag> {

    private static final long serialVersionUID = -975993432L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QThemeReviewTag themeReviewTag = new QThemeReviewTag("themeReviewTag");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QThemeReview review;

    public final EnumPath<feelmeal.global.common.entity.Constant.ThemeReviewTag> tag = createEnum("tag", feelmeal.global.common.entity.Constant.ThemeReviewTag.class);

    public QThemeReviewTag(String variable) {
        this(ThemeReviewTag.class, forVariable(variable), INITS);
    }

    public QThemeReviewTag(Path<? extends ThemeReviewTag> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QThemeReviewTag(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QThemeReviewTag(PathMetadata metadata, PathInits inits) {
        this(ThemeReviewTag.class, metadata, inits);
    }

    public QThemeReviewTag(Class<? extends ThemeReviewTag> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.review = inits.isInitialized("review") ? new QThemeReview(forProperty("review"), inits.get("review")) : null;
    }

}

