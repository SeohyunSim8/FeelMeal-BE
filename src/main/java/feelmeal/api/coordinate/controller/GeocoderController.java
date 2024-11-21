package feelmeal.api.coordinate.controller;

import feelmeal.api.coordinate.controller.dto.request.PostCoordinateRequest;
import feelmeal.api.coordinate.service.GeocoderServiceImpl;
import feelmeal.global.annotation.NonAuth;
import feelmeal.global.common.exception.ErrorResponse;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    // 도로명 주소의 좌표 저장 API
    @NonAuth
    @Operation(summary = "도로명 주소의 좌표 저장 API", description = "도로명 주소를 좌표로 변환하여 DB에 저장합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "요청이 성공적으로 처리되었습니다."),
            @ApiResponse(responseCode = "400", description = "잘못된 요청입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "405", description = "허용되지 않은 메서드입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "내부 서버 오류입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
    })
    @PatchMapping("/address-to-coordinate")
    public String convertAddressToCoordinate(
            @Valid @RequestBody PostCoordinateRequest request
    ) {
        geocoderServiceImpl.convertAddressToCoordinate(request.toServiceDto());
        return "도로명 주소를 성공적으로 좌표로 변환하여 DB에 저장했습니다.";
    }
}