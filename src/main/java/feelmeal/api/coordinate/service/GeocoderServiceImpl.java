package feelmeal.api.coordinate.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import feelmeal.api.coordinate.service.dto.PostCoordinateServiceDto;
import feelmeal.api.member.service.MemberServiceImpl;
import feelmeal.domain.member.entity.Member;
import feelmeal.global.common.entity.Constant;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
public class GeocoderServiceImpl implements GeocoderService {
    private final MemberServiceImpl memberService;

    @Value("${geocoder.key}")
    private String geocoderKey;

    @Transactional
    public void convertAddressToCoordinate(PostCoordinateServiceDto dto) {
        String address = dto.getAddress();                                                      // 주소 가져오기
        List<Double> coordinate = geocoder("경기도 성남시 " + address);                 // 변환
        Member member = memberService.findMemberByIdx(dto.getIdx(), Constant.Status.ACTIVE);    // 멤버 조회
        member.modifyCoordinate(coordinate.get(0), coordinate.get(1));                          // 좌표 저장
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
