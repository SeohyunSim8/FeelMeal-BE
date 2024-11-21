package feelmeal.api.d.service.dto;

import feelmeal.global.common.entity.Constant;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetThemeLikedListServiceDto {
    private Long memberId;

    private Integer page;

    private String keyword;

    private Long stationId;

    private Constant.Genre genre;

    private Float level;

    @Builder
    public GetThemeLikedListServiceDto(Long memberId, Integer page, String keyword, Long stationId, Constant.Genre genre, Float level) {
        this.memberId = memberId;
        this.page = page;
        this.keyword = keyword;
        this.stationId = stationId;
        this.genre = genre;
        this.level = level;
    }
}