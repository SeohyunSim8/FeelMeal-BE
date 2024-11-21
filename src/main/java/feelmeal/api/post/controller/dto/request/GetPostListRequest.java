package feelmeal.api.post.controller.dto.request;

import feelmeal.api.post.service.dto.GetPostListServiceDto;
import feelmeal.global.common.entity.Constant;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GetPostListRequest {
    @NotNull
    @Schema(description = "게시판 종류(THEME: 인생테마, QUESTION: 질문)를 입력해주세요.", example = "THEME")
    private Constant.PostType postType;

    @Schema(description = "검색어 (제목, 본문)", example = "가")
    private String keyword;

    @NotNull
    @Schema(description = "정렬 기준 (LATEST: 최신순, OLDEST: 오래된 순, LIKES: 좋아요 많은 순, COMMENTS: 댓글 많은 순)", example = "LATEST")
    private Constant.PostSortOption postSortOption;

    public GetPostListServiceDto toServiceDto(Integer page) {
        return GetPostListServiceDto.builder()
                .page(page)
                .postType(postType)
                .keyword(keyword)
                .postSortOption(postSortOption)
                .build();
    }
}