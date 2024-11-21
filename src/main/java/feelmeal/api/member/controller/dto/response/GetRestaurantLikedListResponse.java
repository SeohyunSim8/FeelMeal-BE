package feelmeal.api.member.controller.dto.response;

import com.querydsl.core.annotations.QueryProjection;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetRestaurantLikedListResponse {
    @Schema(description = "이름", example = "")
    private String name;

    @Schema(description = "주소", example = "복정동 ")
    private String address;

    @QueryProjection
    @Builder
    public GetRestaurantLikedListResponse(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public static GetRestaurantLikedListResponse of(String name, String address) {
        return GetRestaurantLikedListResponse.builder()
                .name(name)
                .address(address)
                .build();
    }
}