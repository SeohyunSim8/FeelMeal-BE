package feelmeal.api.coordinate.service.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostCoordinateServiceDto {
    private Long idx;
    private String address;

    @Builder
    public PostCoordinateServiceDto(Long idx, String address) {
        this.idx = idx;
        this.address = address;
    }
}
