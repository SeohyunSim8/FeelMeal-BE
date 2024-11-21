package feelmeal.domain.restaurant.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "station")
public class Station {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "town_id", nullable = false)
    private Town town;

    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @Column(name = "address", nullable = false, length = 70)
    private String address;

    @Column(name = "longitude", nullable = true)
    private Double longitude;

    @Column(name = "latitude", nullable = true)
    private Double latitude;

    @Builder
    public Station(Town town, String name, String address, Double longitude, Double latitude) {
        this.town = town;
        this.name = name;
        this.address = address;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public static Station of(Town town, String name, String address) {
        return Station.builder()
                .town(town)
                .name(name)
                .address(address)
                .build();
    }

    public void modifyStation(Double longitude, Double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }
}