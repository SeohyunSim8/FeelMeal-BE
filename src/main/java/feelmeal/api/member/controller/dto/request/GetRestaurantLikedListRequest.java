package feelmeal.api.member.controller.dto.request;

import feelmeal.api.member.service.dto.PatchAddressServiceDto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetRestaurantLikedListRequest {
    @NotNull
    @Schema(description = "멤버 고유번호", example = "1")
    private Long idx;

    public PatchAddressServiceDto toServiceDto() {
        return PatchAddressServiceDto.builder()
                .idx(idx)
                .build();
    }
}
