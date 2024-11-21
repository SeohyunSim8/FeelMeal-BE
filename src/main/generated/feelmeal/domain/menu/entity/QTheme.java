package feelmeal.domain.menu.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTheme is a Querydsl query type for Menu
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTheme extends EntityPathBase<Menu> {

    private static final long serialVersionUID = 18307389L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTheme theme = new QTheme("menu");

    public final feelmeal.global.common.entity.QBaseEntity _super = new feelmeal.global.common.entity.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final EnumPath<feelmeal.global.common.entity.Constant.Genre> genre = createEnum("genre", feelmeal.global.common.entity.Constant.Genre.class);

    public final NumberPath<Float> horrorLevel = createNumber("horrorLevel", Float.class);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath img = createString("img");

    public final NumberPath<Float> level = createNumber("level", Float.class);

    public final StringPath name = createString("name");

    public final NumberPath<Integer> playTime = createNumber("playTime", Integer.class);

    public final feelmeal.domain.restaurant.entity.QPoint point;

    //inherited
    public final EnumPath<feelmeal.global.common.entity.BaseEntity.Status> status = _super.status;

    public final StringPath synopsis = createString("synopsis");

    public final ListPath<ThemeLike, QThemeLike> themeLikes = this.<ThemeLike, QThemeLike>createList("themeLikes", ThemeLike.class, QThemeLike.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QTheme(String variable) {
        this(Menu.class, forVariable(variable), INITS);
    }

    public QTheme(Path<? extends Menu> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTheme(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTheme(PathMetadata metadata, PathInits inits) {
        this(Menu.class, metadata, inits);
    }

    public QTheme(Class<? extends Menu> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.point = inits.isInitialized("restaurant") ? new feelmeal.domain.restaurant.entity.QPoint(forProperty("restaurant"), inits.get("restaurant")) : null;
    }

}

