package feelmeal.api.coordinate.controller;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RestController;
import feelmeal.api.coordinate.service.GeocoderService;

import java.io.IOException;

@Slf4j
@Hidden
@RequiredArgsConstructor
@RestController
@Tag(name = "[Coordinate]", description = "좌표 관련 API")
public class GeocoderController {
    private final GeocoderService geocoderService;

    @Operation(summary = "도로명 주소의 좌표 저장 API", description = "도로명 주소를 좌표로 변환하여 DB에 저장합니다.")
    @PatchMapping("/address-to-coordinate")
    public String convertAddressToCoordinate() throws IOException {
        geocoderService.convertStationToCoordinate();
        geocoderService.convertPointToCoordinate();
        return "도로명 주소를 성공적으로 좌표로 변환하여 DB에 저장했습니다.";
    }

    @Operation(summary = "방탈출 카페 지점의 최단거리 지하철 역 저장 API", description = "방탈출 카페 지점의 가장 가까운 역을 계산하여 DB에 저장합니다.")
    @PatchMapping("/coordinate-to-station")
    public String convertCoordinateToStation() throws IOException {
        geocoderService.nearestStation();
        return "방탈출 카페 지점의 가장 가까운 역을 성공적으로 DB에 저장했습니다.";
    }
}