package feelmeal.domain.restaurant.repository;

import feelmeal.domain.restaurant.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
//    // 방탈출 카페 지점과 가장 가까운 지하철 역 조회
//    @Query("""
//        SELECT s
//        FROM Station s
//        JOIN Restaurant p ON p.id = :pointId
//        ORDER BY ST_Distance_Sphere(d(s.longitude, s.latitude), d(p.longitude, p.latitude)) ASC
//        LIMIT 1
//    """)
//    Station findNearestStationByCoordinate(@Param("pointId") Long pointId);
}

