package feelmeal.domain.menu.entity;

import feelmeal.global.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "theme_price")
public class ThemePrice {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "theme_id", nullable = false)
    private Menu menu;

    @Column(name = "headcount", nullable = false)
    private Integer headcount;

    @Column(name = "price", nullable = false)
    private Integer price;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private BaseEntity.Status status = BaseEntity.Status.ACTIVE;

    @Builder
    public ThemePrice(Menu menu, Integer headcount, Integer price) {
        this.menu = menu;
        this.headcount = headcount;
        this.price = price;
    }

    public static ThemePrice of(Menu menu, Integer headcount, Integer price) {
        return ThemePrice.builder()
                .theme(menu)
                .headcount(headcount)
                .price(price)
                .build();
    }
}