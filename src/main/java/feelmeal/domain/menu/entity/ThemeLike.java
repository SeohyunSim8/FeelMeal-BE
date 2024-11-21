package feelmeal.domain.menu.entity;

import feelmeal.domain.member.entity.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "theme_like")
public class ThemeLike {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "theme_id", nullable = false)
    private Menu menu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @Builder
    public ThemeLike(Menu menu, Member member) {
        this.menu = menu;
        this.member = member;
    }

    public static ThemeLike of(Menu menu, Member member) {
        return ThemeLike.builder()
                .theme(menu)
                .member(member)
                .build();
    }
}