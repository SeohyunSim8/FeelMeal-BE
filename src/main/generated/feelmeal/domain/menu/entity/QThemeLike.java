package feelmeal.domain.menu.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QThemeLike is a Querydsl query type for ThemeLike
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QThemeLike extends EntityPathBase<ThemeLike> {

    private static final long serialVersionUID = -1420284673L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QThemeLike themeLike = new QThemeLike("themeLike");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final feelmeal.domain.member.entity.QMember member;

    public final QMenu menu;

    public QThemeLike(String variable) {
        this(ThemeLike.class, forVariable(variable), INITS);
    }

    public QThemeLike(Path<? extends ThemeLike> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QThemeLike(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QThemeLike(PathMetadata metadata, PathInits inits) {
        this(ThemeLike.class, metadata, inits);
    }

    public QThemeLike(Class<? extends ThemeLike> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new feelmeal.domain.member.entity.QMember(forProperty("member")) : null;
        this.menu = inits.isInitialized("menu") ? new QMenu(forProperty("menu"), inits.get("menu")) : null;
    }

}

