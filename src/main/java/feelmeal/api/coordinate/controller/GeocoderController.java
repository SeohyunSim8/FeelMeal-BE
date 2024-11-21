package feelmeal.api.coordinate.controller;

import feelmeal.api.coordinate.controller.dto.request.PostCoordinateRequest;
import feelmeal.api.coordinate.service.GeocoderServiceImpl;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Hidden
@RequiredArgsConstructor
@RestController
@Tag(name = "[Coordinate]", description = "좌표 관련 API")
public class GeocoderController {
    private final GeocoderServiceImpl geocoderServiceImpl;

    @Operation(summary = "도로명 주소의 좌표 저장 API", description = "도로명 주소를 좌표로 변환하여 DB에 저장합니다.")
    @PatchMapping("/address-to-coordinate")
    public String convertAddressToCoordinate(
            @Valid @RequestBody PostCoordinateRequest request
    ) {
        geocoderServiceImpl.convertAddressToCoordinate(request.toServiceDto());
        return "도로명 주소를 성공적으로 좌표로 변환하여 DB에 저장했습니다.";
    }
}