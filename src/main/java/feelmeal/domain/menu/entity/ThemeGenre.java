package feelmeal.domain.menu.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import feelmeal.global.common.entity.BaseEntity;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "theme_genre")
public class ThemeGenre {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "theme_id", nullable = false)
    private Menu menu;

    @Column(name = "genre", nullable = false, length = 50)
    private String genre;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private BaseEntity.Status status = BaseEntity.Status.ACTIVE;

    @Builder
    public ThemeGenre(Menu menu, String genre) {
        this.menu = menu;
        this.genre = genre;
    }

    public static ThemeGenre of(Menu menu, String genre) {
        return ThemeGenre.builder()
                .theme(menu)
                .genre(genre)
                .build();
    }
}