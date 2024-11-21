package feelmeal.api.post.service.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import feelmeal.global.common.entity.Constant;

@Getter
@NoArgsConstructor
public class GetPostListServiceDto {
    private Constant.PostType postType;
    private Integer page;
    private String keyword;
    private Constant.PostSortOption postSortOption;

    @Builder
    public GetPostListServiceDto(Integer page, Constant.PostType postType, String keyword, Constant.PostSortOption postSortOption) {
        this.page = page;
        this.postType = postType;
        this.keyword = keyword;
        this.postSortOption = postSortOption;
    }
}