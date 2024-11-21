package feelmeal.api.member.service.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetRestaurantLikedListServiceDto {
    private Long idx;

    @Builder
    public GetRestaurantLikedListServiceDto(Long idx) {
        this.idx = idx;
    }
}
