package feelmeal.domain.booking.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QThemeBooking is a Querydsl query type for ThemeBooking
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QThemeBooking extends EntityPathBase<ThemeBooking> {

    private static final long serialVersionUID = 798212460L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QThemeBooking themeBooking = new QThemeBooking("themeBooking");

    public final feelmeal.global.common.entity.QBaseEntity _super = new feelmeal.global.common.entity.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final feelmeal.domain.member.entity.QMember member;

    public final DateTimePath<java.time.LocalDateTime> reservedAt = createDateTime("reservedAt", java.time.LocalDateTime.class);

    //inherited
    public final EnumPath<feelmeal.global.common.entity.BaseEntity.Status> status = _super.status;

    public final feelmeal.domain.menu.entity.QTheme theme;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QThemeBooking(String variable) {
        this(ThemeBooking.class, forVariable(variable), INITS);
    }

    public QThemeBooking(Path<? extends ThemeBooking> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QThemeBooking(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QThemeBooking(PathMetadata metadata, PathInits inits) {
        this(ThemeBooking.class, metadata, inits);
    }

    public QThemeBooking(Class<? extends ThemeBooking> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new feelmeal.domain.member.entity.QMember(forProperty("member")) : null;
        this.theme = inits.isInitialized("menu") ? new feelmeal.domain.menu.entity.QTheme(forProperty("menu"), inits.get("menu")) : null;
    }

}

