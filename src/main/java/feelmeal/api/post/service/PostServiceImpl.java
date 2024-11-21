package feelmeal.api.post.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import feelmeal.api.member.service.MemberServiceImpl;
import feelmeal.api.post.controller.dto.response.GetCommentListResponse;
import feelmeal.api.post.controller.dto.response.GetHomePostResponse;
import feelmeal.api.post.controller.dto.response.GetPostListResponse;
import feelmeal.api.post.controller.dto.response.GetPostResponse;
import feelmeal.api.post.service.dto.*;
import feelmeal.domain.member.entity.Member;
import feelmeal.domain.post.entity.Post;
import feelmeal.domain.post.entity.PostComment;
import feelmeal.domain.post.entity.PostLike;
import feelmeal.domain.post.repository.PostCommentRepository;
import feelmeal.domain.post.repository.PostLikeRepository;
import feelmeal.domain.post.repository.PostRepository;
import feelmeal.global.common.entity.BaseEntity;
import feelmeal.global.common.exception.CustomException;
import feelmeal.global.common.exception.ResponseCode;
import feelmeal.global.common.response.PageResponse;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final PostLikeRepository postLikeRepository;
    private final PostCommentRepository postCommentRepository;

    private final MemberServiceImpl memberService;

    private PageRequest pageRequest;

    // 게시판 홈의 게시판별 게시판 목록 조회 API
    public List<GetHomePostResponse> getHomeList(GetHomeListServiceDto dto) {
        return postRepository.find6PostsByPostType(dto.getPostType());
    }

    // 게시판별 게시판 목록 조회 API
    public PageResponse<GetPostListResponse> getPostList(GetPostListServiceDto dto) {
        pageRequest = PageRequest.of(dto.getPage() - 1, 10);

        Page<GetPostListResponse> postPage =
                postRepository.findAllByPostTypeOrderBySortOption(
                        pageRequest, dto.getPostType(), BaseEntity.Status.ACTIVE, dto.getKeyword(), dto.getPostSortOption());

        return PageResponse.from(postPage);
    }


    // 게시물 상세 조회 API
    public GetPostResponse getPost(GetPostServiceDto dto) {
        // 게시물 조회
        Post post = findPostById(dto.getPostId(), BaseEntity.Status.ACTIVE);

        return postRepository.findPostById(post.getId());
    }

    // 게시물 댓글 조회 API
    public PageResponse<GetCommentListResponse> getPostCommentList(GetPostCommentListServiceDto dto) {
        // 게시물 조회
        Post post = findPostById(dto.getPostId(), BaseEntity.Status.ACTIVE);

        pageRequest = PageRequest.of(dto.getPage() - 1, 20);

        Page<GetCommentListResponse> commentPage = postRepository.findCommentById(pageRequest, dto.getPostId());

        return PageResponse.from(commentPage);
    }


    // 게시물 좋아요 API
    @Transactional
    public void createLike(PostLikeServiceDto dto) {
        // member 조회
        Member member = memberService.findEntityById(dto.getMemberId(), BaseEntity.Status.ACTIVE);

        // post 조회
        Post post = findPostById(dto.getPostId(), BaseEntity.Status.ACTIVE);

        // postLike 조회 후, 있다면 예외 발생, 없다면 새로 생성
        if(postLikeRepository.findByPostIdAndMemberId(post.getId(), member.getId()).isPresent())
            throw new CustomException(ResponseCode.EXIST_LIKE);

        postLikeRepository.save(PostLike.of(post, member));
    }

    // 게시물 좋아요 취소 API
    @Transactional
    public void deleteLike(DeleteLikeServiceDto dto) {
        // member 조회
        Member member = memberService.findEntityById(dto.getMemberId(), BaseEntity.Status.ACTIVE);

        // post 조회
        Post post = findPostById(dto.getPostId(), BaseEntity.Status.ACTIVE);

        // postLike 조회 후, 있다면 삭제, 없다면 예외 발생
        Optional<PostLike> postLike = postLikeRepository.findByPostIdAndMemberId(post.getId(), member.getId());

        if(postLike.isEmpty())
            throw new CustomException(ResponseCode.NOT_FOUND_POSTLIKE);

        postLikeRepository.delete(postLike.get());
    }


    // 게시물 생성 API
    @Transactional
    public void createPost(PostPostServiceDto dto) {
        // member 조회
        Member member = memberService.findEntityById(dto.getMemberId(), BaseEntity.Status.ACTIVE);

        postRepository.save(Post.of(member, dto.getPostType(), dto.getTitle(), dto.getContent()));
    }

    // 게시물 수정 API
    @Transactional
    public void modifyPost(PatchPostServiceDto dto) {
        // member 조회
        memberService.findEntityById(dto.getMemberId(), BaseEntity.Status.ACTIVE);

        // post 조회 및 작성자 본인 확인
        Post post = findPostById(dto.getPostId(), BaseEntity.Status.ACTIVE);
        if(!post.getMember().getId().equals(dto.getMemberId()))
            throw new CustomException(ResponseCode.UNAUTHORIZED_POST);

        post.modifyPost(dto);
    }

    // 게시물 삭제 API (soft delete)
    @Transactional
    public void deletePost(DeletePostServiceDto dto) {
        // member 조회
        memberService.findEntityById(dto.getMemberId(), BaseEntity.Status.ACTIVE);

        // post 조회 및 작성자 본인 확인
        Post post = findPostById(dto.getPostId(), BaseEntity.Status.ACTIVE);
        if(!post.getMember().getId().equals(dto.getMemberId()))
            throw new CustomException(ResponseCode.UNAUTHORIZED_POST);

        post.deletePost();
    }

    // 댓글 생성 API
    @Transactional
    public void createComment(PostCommentServiceDto dto) {
        // member 조회
        Member member = memberService.findEntityById(dto.getMemberId(), BaseEntity.Status.ACTIVE);

        // post 조회
        Post post = findPostById(dto.getPostId(), BaseEntity.Status.ACTIVE);

        postCommentRepository.save(PostComment.of(post, member, dto.getContent()));
    }

    // 댓글 수정 API
    @Transactional
    public void modifyComment(PatchCommentServiceDto dto) {
        // member 조회
        Member member = memberService.findEntityById(dto.getMemberId(), BaseEntity.Status.ACTIVE);

        // post 조회 및 작성자 본인 확인
        Post post = findPostById(dto.getPostId(), BaseEntity.Status.ACTIVE);

        // postComment 조회 및 post와 작성자 본인 확인
        PostComment postComment = findPostCommentById(dto.getCommentId(), BaseEntity.Status.ACTIVE);
        if(!postComment.getPost().getId().equals(post.getId()))
            throw new CustomException(ResponseCode.INVALID_COMMENT);
        if(!postComment.getMember().getId().equals(member.getId()))
            throw new CustomException(ResponseCode.UNAUTHORIZED_COMMENT);

        postComment.modifyComment(dto);
    }

    // 댓글 삭제 API (soft delete)
    @Transactional
    public void deleteComment(DeleteCommentServiceDto dto) {
        // member 조회
        Member member = memberService.findEntityById(dto.getMemberId(), BaseEntity.Status.ACTIVE);

        // post 조회 및 작성자 본인 확인
        Post post = findPostById(dto.getPostId(), BaseEntity.Status.ACTIVE);

        // postComment 조회 및 post와 작성자 본인 확인
        PostComment postComment = findPostCommentById(dto.getCommentId(), BaseEntity.Status.ACTIVE);
        if(!postComment.getPost().getId().equals(post.getId()))
            throw new CustomException(ResponseCode.INVALID_COMMENT);
        if(!postComment.getMember().getId().equals(member.getId()))
            throw new CustomException(ResponseCode.UNAUTHORIZED_COMMENT);

        postComment.deleteComment();
    }

    public Post findPostById(Long postId, BaseEntity.Status status) {
        return postRepository.findByIdAndStatus(postId, status)
                .orElseThrow(() -> new CustomException(ResponseCode.NOT_FOUND_POST));
    }

    public PostComment findPostCommentById(Long commentId, BaseEntity.Status status) {
        return postCommentRepository.findByIdAndStatus(commentId, status)
                .orElseThrow(() -> new CustomException(ResponseCode.NOT_FOUND_COMMENT));
    }
}
