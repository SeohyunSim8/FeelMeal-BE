package feelmeal.api.theme.controller.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetLocationThemeListResponse {
    @Schema(description = "아이디", example = "1")
    private Long id;

    @Schema(description = "이름", example = "넥스트에디션 강남3호점")
    private String name;

    @Schema(description = "주소", example = "서울 서초구 강남대로65길 7 피렌체타워 5층")
    private String address;

    @Schema(description = "좌표 경도", example = "127.025329353")
    private Double longitude;

    @Schema(description = "좌표 위도", example = "37.500259252")
    private Double latitude;

    @Builder
    public GetLocationThemeListResponse(Long id, String name, String address, Double longitude, Double latitude) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public static GetLocationThemeListResponse of(Long id, String name, String address, Double longitude, Double latitude) {
        return GetLocationThemeListResponse.builder()
                .id(id)
                .name(name)
                .address(address)
                .longitude(longitude)
                .latitude(latitude)
                .build();
    }
}
