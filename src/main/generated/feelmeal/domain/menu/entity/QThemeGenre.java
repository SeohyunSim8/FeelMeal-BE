package feelmeal.domain.menu.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QThemeGenre is a Querydsl query type for ThemeGenre
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QThemeGenre extends EntityPathBase<ThemeGenre> {

    private static final long serialVersionUID = 1623719494L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QThemeGenre themeGenre = new QThemeGenre("themeGenre");

    public final StringPath genre = createString("genre");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final EnumPath<feelmeal.global.common.entity.BaseEntity.Status> status = createEnum("status", feelmeal.global.common.entity.BaseEntity.Status.class);

    public final QTheme theme;

    public QThemeGenre(String variable) {
        this(ThemeGenre.class, forVariable(variable), INITS);
    }

    public QThemeGenre(Path<? extends ThemeGenre> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QThemeGenre(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QThemeGenre(PathMetadata metadata, PathInits inits) {
        this(ThemeGenre.class, metadata, inits);
    }

    public QThemeGenre(Class<? extends ThemeGenre> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.theme = inits.isInitialized("menu") ? new QTheme(forProperty("menu"), inits.get("menu")) : null;
    }

}

