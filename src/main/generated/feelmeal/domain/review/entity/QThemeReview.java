package feelmeal.domain.review.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QThemeReview is a Querydsl query type for ThemeReview
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QThemeReview extends EntityPathBase<ThemeReview> {

    private static final long serialVersionUID = 1199317138L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QThemeReview themeReview = new QThemeReview("themeReview");

    public final feelmeal.global.common.entity.QBaseEntity _super = new feelmeal.global.common.entity.QBaseEntity(this);

    public final StringPath activityInfo = createString("activityInfo");

    public final NumberPath<Float> activityLevel = createNumber("activityLevel", Float.class);

    public final EnumPath<feelmeal.global.common.entity.Constant.Clothes> clothes = createEnum("clothes", feelmeal.global.common.entity.Constant.Clothes.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final EnumPath<feelmeal.global.common.entity.Constant.FailReason> failReason = createEnum("failReason", feelmeal.global.common.entity.Constant.FailReason.class);

    public final NumberPath<Integer> headcount = createNumber("headcount", Integer.class);

    public final StringPath horrorInfo = createString("horrorInfo");

    public final NumberPath<Float> horrorLevel = createNumber("horrorLevel", Float.class);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath interiorInfo = createString("interiorInfo");

    public final NumberPath<Float> interiorLevel = createNumber("interiorLevel", Float.class);

    public final EnumPath<feelmeal.global.common.entity.Constant.IsEscaped> isEscaped = createEnum("isEscaped", feelmeal.global.common.entity.Constant.IsEscaped.class);

    public final TimePath<java.time.LocalTime> leftTime = createTime("leftTime", java.time.LocalTime.class);

    public final NumberPath<Float> level = createNumber("level", Float.class);

    public final StringPath levelInfo = createString("levelInfo");

    public final NumberPath<Integer> lockRatio = createNumber("lockRatio", Integer.class);

    public final StringPath lockRatioInfo = createString("lockRatioInfo");

    public final feelmeal.domain.member.entity.QMember member;

    public final DatePath<java.time.LocalDate> playedAt = createDate("playedAt", java.time.LocalDate.class);

    public final StringPath review = createString("review");

    public final EnumPath<feelmeal.global.common.entity.Constant.Review> reviewEnum = createEnum("reviewEnum", feelmeal.global.common.entity.Constant.Review.class);

    //inherited
    public final EnumPath<feelmeal.global.common.entity.BaseEntity.Status> status = _super.status;

    public final StringPath storyInfo = createString("storyInfo");

    public final NumberPath<Float> storyLevel = createNumber("storyLevel", Float.class);

    public final feelmeal.domain.menu.entity.QTheme theme;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final NumberPath<Integer> usedHint = createNumber("usedHint", Integer.class);

    public QThemeReview(String variable) {
        this(ThemeReview.class, forVariable(variable), INITS);
    }

    public QThemeReview(Path<? extends ThemeReview> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QThemeReview(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QThemeReview(PathMetadata metadata, PathInits inits) {
        this(ThemeReview.class, metadata, inits);
    }

    public QThemeReview(Class<? extends ThemeReview> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new feelmeal.domain.member.entity.QMember(forProperty("member")) : null;
        this.theme = inits.isInitialized("menu") ? new feelmeal.domain.menu.entity.QTheme(forProperty("menu"), inits.get("menu")) : null;
    }

}

