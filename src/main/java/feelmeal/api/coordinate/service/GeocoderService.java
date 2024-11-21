package feelmeal.api.coordinate.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import feelmeal.domain.restaurant.entity.Restaurant;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import feelmeal.domain.restaurant.entity.Station;
import feelmeal.domain.restaurant.repository.RestaurantRepository;
import feelmeal.domain.restaurant.repository.StationRepository;
import feelmeal.global.common.entity.BaseEntity;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class GeocoderService {
    private final StationRepository stationRepository;
    private final RestaurantRepository restaurantRepository;

    @Value("${geocoder.key}")
    private String geocoderKey;

    @Transactional
    public void convertStationToCoordinate() {
        List<Station> stationList = stationRepository.findAll();

        for (Station station : stationList) {
            List<Double> coordinate = geocoder(station.getAddress());       // 변환
            station.modifyStation(coordinate.get(0), coordinate.get(1));    // 저장
        }
    }

    @Transactional
    public void convertPointToCoordinate() {
        List<Restaurant> restaurantList = restaurantRepository.findAllByStatus(BaseEntity.Status.ACTIVE);

        for (Restaurant restaurant : restaurantList) {
            List<Double> coordinate = geocoder(restaurant.getAddress());     // 변환
            restaurant.modifyCoordinate(coordinate.get(0), coordinate.get(1));    // 저장
        }
    }

    @Transactional
    public void nearestStation() {
        List<Restaurant> restaurantList = restaurantRepository.findAllByStatus(BaseEntity.Status.ACTIVE);

        for (Restaurant restaurant : restaurantList) {
            // 가장 가까운 역 아이디 찾기
            Station station = restaurantRepository.findNearestStationByCoordinate(restaurant.getId());
            restaurant.modifyStation(station);   // 저장
        }
    }

    private List<Double> geocoder(String searchAddr) {
        StringBuilder sb = new StringBuilder("https://api.vworld.kr/req/address" +
                "?service=address" +
                "&request=getCoord" +
                "&format=json&crs=epsg:4326" +
                "&type=ROAD");
        sb.append("&key=" + geocoderKey);
        sb.append("&address=" + URLEncoder.encode(searchAddr, StandardCharsets.UTF_8));

        try{
            // 요청
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(sb.toString()))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(response.body());

            // JSON 필드 탐색
            JsonNode pointNode = rootNode.path("response").path("result").path("restaurant");

            // 결과값 반환
            double x = pointNode.path("x").asDouble();
            double y = pointNode.path("y").asDouble();

            return List.of(x, y);
        } catch (IOException | URISyntaxException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
