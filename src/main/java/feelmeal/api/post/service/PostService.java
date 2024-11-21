package feelmeal.api.post.service;

import feelmeal.api.post.controller.dto.response.GetCommentListResponse;
import feelmeal.api.post.controller.dto.response.GetHomePostResponse;
import feelmeal.api.post.controller.dto.response.GetPostListResponse;
import feelmeal.api.post.controller.dto.response.GetPostResponse;
import feelmeal.api.post.service.dto.*;
import feelmeal.global.common.response.PageResponse;

import java.util.List;

public interface PostService {
    List<GetHomePostResponse> getHomeList(GetHomeListServiceDto dto);

    PageResponse<GetPostListResponse> getPostList(GetPostListServiceDto dto);

    GetPostResponse getPost(GetPostServiceDto dto);

    PageResponse<GetCommentListResponse> getPostCommentList(GetPostCommentListServiceDto dto);

    void createLike(PostLikeServiceDto dto);

    void deleteLike(DeleteLikeServiceDto dto);

    void createPost(PostPostServiceDto dto);

    void modifyPost(PatchPostServiceDto dto);

    void deletePost(DeletePostServiceDto dto);

    void createComment(PostCommentServiceDto dto);

    void modifyComment(PatchCommentServiceDto dto);

    void deleteComment(DeleteCommentServiceDto dto);
}
