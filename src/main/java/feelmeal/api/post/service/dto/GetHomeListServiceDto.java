package feelmeal.api.post.service.dto;

import feelmeal.global.common.entity.Constant;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetHomeListServiceDto {
    private Constant.PostType postType;

    @Builder
    public GetHomeListServiceDto(Constant.PostType postType) {
        this.postType = postType;
    }

    public static GetHomeListServiceDto of(Constant.PostType postType) {
        return GetHomeListServiceDto.builder()
                .postType(postType)
                .build();
    }
}