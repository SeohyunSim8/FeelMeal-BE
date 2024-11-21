package feelmeal.api.d.controller.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetLocationStationListResponse {
    @Schema(description = "지역(지하철역) 아이디", example = "1")
    private Long stationId;

    @Schema(description = "지역(지하철역)", example = "신림")
    private String station;

    @Builder
    public GetLocationStationListResponse(Long stationId, String station) {
        this.stationId = stationId;
        this.station = station;
    }

    public static GetLocationStationListResponse of(Long stationId, String station) {
        return GetLocationStationListResponse.builder()
                .stationId(stationId)
                .station(station)
                .build();
    }
}
