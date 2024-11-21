package feelmeal.domain.member.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = 912751019L;

    public static final QMember member = new QMember("member1");

    public final feelmeal.global.common.entity.QBaseEntity _super = new feelmeal.global.common.entity.QBaseEntity(this);

    public final StringPath about = createString("about");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath email = createString("email");

    public final EnumPath<feelmeal.global.common.entity.Constant.Genre> genre = createEnum("genre", feelmeal.global.common.entity.Constant.Genre.class);

    public final EnumPath<feelmeal.global.common.entity.Constant.HorrorPos> horrorPos = createEnum("horrorPos", feelmeal.global.common.entity.Constant.HorrorPos.class);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath nickname = createString("nickname");

    public final EnumPath<feelmeal.global.common.entity.Constant.Proficiency> proficiency = createEnum("proficiency", feelmeal.global.common.entity.Constant.Proficiency.class);

    public final StringPath profileImgUrl = createString("profileImgUrl");

    public final StringPath pw = createString("pw");

    //inherited
    public final EnumPath<feelmeal.global.common.entity.BaseEntity.Status> status = _super.status;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QMember(String variable) {
        super(Member.class, forVariable(variable));
    }

    public QMember(Path<? extends Member> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMember(PathMetadata metadata) {
        super(Member.class, metadata);
    }

}

