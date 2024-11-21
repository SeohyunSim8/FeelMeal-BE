package feelmeal.domain.menu.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QThemePrice is a Querydsl query type for ThemePrice
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QThemePrice extends EntityPathBase<ThemePrice> {

    private static final long serialVersionUID = -1075191583L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QThemePrice themePrice = new QThemePrice("themePrice");

    public final NumberPath<Integer> headcount = createNumber("headcount", Integer.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QMenu menu;

    public final NumberPath<Integer> price = createNumber("price", Integer.class);

    public final NumberPath<feelmeal.global.common.entity.BaseEntity.Status> status = createNumber("status", feelmeal.global.common.entity.BaseEntity.Status.class);

    public QThemePrice(String variable) {
        this(ThemePrice.class, forVariable(variable), INITS);
    }

    public QThemePrice(Path<? extends ThemePrice> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QThemePrice(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QThemePrice(PathMetadata metadata, PathInits inits) {
        this(ThemePrice.class, metadata, inits);
    }

    public QThemePrice(Class<? extends ThemePrice> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.menu = inits.isInitialized("menu") ? new QMenu(forProperty("menu"), inits.get("menu")) : null;
    }

}

