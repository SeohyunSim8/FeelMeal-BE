package feelmeal.domain.restaurant.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStation is a Querydsl query type for Station
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStation extends EntityPathBase<Station> {

    private static final long serialVersionUID = -1817997055L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QStation station = new QStation("station");

    public final StringPath address = createString("address");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Double> latitude = createNumber("latitude", Double.class);

    public final NumberPath<Double> longitude = createNumber("longitude", Double.class);

    public final StringPath name = createString("name");

    public final QTown town;

    public QStation(String variable) {
        this(Station.class, forVariable(variable), INITS);
    }

    public QStation(Path<? extends Station> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QStation(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QStation(PathMetadata metadata, PathInits inits) {
        this(Station.class, metadata, inits);
    }

    public QStation(Class<? extends Station> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.town = inits.isInitialized("town") ? new QTown(forProperty("town"), inits.get("town")) : null;
    }

}

