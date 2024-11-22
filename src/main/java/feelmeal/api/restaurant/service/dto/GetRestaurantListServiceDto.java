package feelmeal.api.restaurant.service.dto;

import feelmeal.api.member.service.dto.PatchAddressServiceDto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetRestaurantListServiceDto {
    private Long memberIdx;

    @Builder
    public GetRestaurantListServiceDto(Long memberIdx) {
        this.memberIdx = memberIdx;
    }

    public static GetRestaurantListServiceDto of(Long memberIdx) {
        return GetRestaurantListServiceDto.builder()
                .memberIdx(memberIdx)
                .build();
    }
}
