package feelmeal.api.post.controller;

import feelmeal.api.post.controller.dto.request.*;
import feelmeal.api.post.controller.dto.response.GetCommentListResponse;
import feelmeal.api.post.controller.dto.response.GetHomePostResponse;
import feelmeal.api.post.controller.dto.response.GetPostListResponse;
import feelmeal.api.post.controller.dto.response.GetPostResponse;
import feelmeal.api.post.service.PostService;
import feelmeal.api.post.service.dto.*;
import feelmeal.global.annotation.NonAuth;
import feelmeal.global.common.entity.Constant;
import feelmeal.global.common.exception.ErrorResponse;
import feelmeal.global.common.jwt.JwtService;
import feelmeal.global.common.response.PageResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static feelmeal.global.common.exception.ResponseCode.SUCCESS;

@Tag(name = "[Post]", description = "게시판 관련 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;
    private final JwtService jwtService;

    // 게시판 홈의 게시물 목록 조회
    @NonAuth
    @Operation(summary = "게시판 홈의 게시판 종류별 게시물 목록 조회 API", description = "게시판 홈의 게시판 종류별 최신 6개의 게시물 목록을 조회합니다.")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "요청이 성공적으로 처리되었습니다."),
            @ApiResponse(responseCode = "400", description = "잘못된 요청입니다.<br>" + "게시판 종류를 찾을 수 없습니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "405", description = "허용되지 않은 메서드입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "내부 서버 오류입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
    })
    @GetMapping("/home")
    public ResponseEntity<List<GetHomePostResponse>> getHomeList(
            @ParameterObject @NotNull
            @Schema(description = "게시판 종류 (THEME: 인생테마, QUESTION: 질문)를 입력해주세요.", example = "THEME")
            Constant.PostType postType
    ) {
        List<GetHomePostResponse> response = postService.getHomeList(GetHomeListServiceDto.of(postType));
        return new ResponseEntity<>(response, SUCCESS.getStatus());
    }

    // 게시물 목록 조회
    @NonAuth
    @Operation(summary = "게시판 종류별 게시물 목록 조회 API", description = "게시판 종류별 게시물 목록을 조회합니다.")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "요청이 성공적으로 처리되었습니다."),
            @ApiResponse(responseCode = "400", description = "잘못된 요청입니다.<br>" + "게시판 종류를 찾을 수 없습니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "405", description = "허용되지 않은 메서드입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "내부 서버 오류입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
    })
    @GetMapping("/list")
    public ResponseEntity<PageResponse<GetPostListResponse>> getPostList(
            @ParameterObject @Valid GetPostListRequest request,
            @ParameterObject @Schema(description = "페이지 번호 (1부터 시작)를 입력해주세요.", example = "1") Integer page
    ) {
        PageResponse<GetPostListResponse> response = postService.getPostList(request.toServiceDto(page));
        return new ResponseEntity<>(response, SUCCESS.getStatus());
    }


    // 게시물 상세 보기
    @NonAuth
    @Operation(summary = "게시물 상세 조회 API", description = "게시물을 상세 조회합니다.")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "요청이 성공적으로 처리되었습니다."),
            @ApiResponse(responseCode = "400", description = "잘못된 요청입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "405", description = "허용되지 않은 메서드입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "내부 서버 오류입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "404", description = "존재하지 않는 게시물입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping("/{postId}")
    public ResponseEntity<GetPostResponse> getPost(
            @PathVariable @Schema(description = "게시물 아이디를 입력해주세요.", example = "1") Long postId
    ) {
        GetPostResponse response = postService.getPost(GetPostServiceDto.of(postId));
        return new ResponseEntity<>(response, SUCCESS.getStatus());
    }

    // 게시물 댓글 보기
    @NonAuth
    @Operation(summary = "게시물 댓글 조회 API", description = "게시물의 댓글을 조회합니다.")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "요청이 성공적으로 처리되었습니다."),
            @ApiResponse(responseCode = "400", description = "잘못된 요청입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "405", description = "허용되지 않은 메서드입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "내부 서버 오류입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "404", description = "존재하지 않는 게시물입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping("/{postId}/comments")
    public ResponseEntity<PageResponse<GetCommentListResponse>> getPostCommentList(
            @PathVariable @Schema(description = "게시물 아이디를 입력해주세요.", example = "1") Long postId,
            @ParameterObject @Schema(description = "페이지 번호 (1부터 시작)를 입력해주세요.", example = "1") Integer page
    ) {
        PageResponse<GetCommentListResponse> response = postService.getPostCommentList(GetPostCommentListServiceDto.of(page, postId));
        return new ResponseEntity<>(response, SUCCESS.getStatus());
    }

    // 게시물 좋아요
    @Operation(summary = "게시물 좋아요 API", description = "게시물에 좋아요를 합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "요청이 성공적으로 처리되었습니다."),
            @ApiResponse(responseCode = "400", description = "잘못된 요청입니다.<br>" + "JWT를 입력해주세요.<br>" + "이미 좋아요를 한 게시물입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "405", description = "허용되지 않은 메서드입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "내부 서버 오류입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "401", description = "유효하지 않은 JWT입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "404", description = "존재하지 않는 유저입니다.<br>" + "존재하지 않는 게시물입니다.<br>" + "이미 좋아요를 한 게시물입니다.<br>", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PostMapping("/{postId}/like")
    public ResponseEntity<String> postLike(
            @PathVariable @Schema(description = "게시물 아이디를 입력해주세요.", example = "1") Long postId
    ) {
        postService.createLike(PostLikeServiceDto.of(jwtService.getMemberIdFromUserDetails(), postId));
        return new ResponseEntity<>(SUCCESS.getMessage(), SUCCESS.getStatus());
    }

    // 게시물 좋아요 취소
    @Operation(summary = "게시물 좋아요 취소 API", description = "게시물에 좋아요를 취소합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "요청이 성공적으로 처리되었습니다."),
            @ApiResponse(responseCode = "400", description = "잘못된 요청입니다.<br>" + "JWT를 입력해주세요.<br>" + "좋아요를 하지 않은 게시물입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "405", description = "허용되지 않은 메서드입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "내부 서버 오류입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "401", description = "유효하지 않은 JWT입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "404", description = "존재하지 않는 유저입니다.<br>" + "존재하지 않는 게시물입니다.<br>" + "좋아요를 하지 않은 게시물입니다.<br>", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @DeleteMapping("/{postId}/dislike")
    public ResponseEntity<String> deleteLike(
            @PathVariable @Schema(description = "게시물 아이디를 입력해주세요.", example = "1") Long postId
    ) {
        postService.deleteLike(DeleteLikeServiceDto.of(jwtService.getMemberIdFromUserDetails(), postId));
        return new ResponseEntity<>(SUCCESS.getMessage(), SUCCESS.getStatus());
    }

    // 게시물 작성
    @Operation(summary = "게시물 생성 API", description = "새 게시물을 작성합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "요청이 성공적으로 처리되었습니다."),
            @ApiResponse(responseCode = "400", description = "잘못된 요청입니다.<br>" + "JWT를 입력해주세요.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "405", description = "허용되지 않은 메서드입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "내부 서버 오류입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "401", description = "유효하지 않은 JWT입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "404", description = "존재하지 않는 유저입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PostMapping()
    public ResponseEntity<String> createPost(
            @RequestBody @Valid PostPostRequest request
    ) {
        postService.createPost(request.toServiceDto(jwtService.getMemberIdFromUserDetails()));
        return new ResponseEntity<>(SUCCESS.getMessage(), SUCCESS.getStatus());
    }

    // 게시물 수정
    @Operation(summary = "게시물 수정 API", description = "게시물을 수정합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "요청이 성공적으로 처리되었습니다."),
            @ApiResponse(responseCode = "400", description = "잘못된 요청입니다.<br>" + "JWT를 입력해주세요.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "405", description = "허용되지 않은 메서드입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "내부 서버 오류입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "401", description = "유효하지 않은 JWT입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "404", description = "존재하지 않는 유저입니다.<br>" + "존재하지 않는 게시물입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PatchMapping("/{postId}")
    public ResponseEntity<String> modifyPost(
            @PathVariable @Schema(description = "게시물 아이디를 입력해주세요.", example = "1") Long postId,
            @RequestBody @Valid PatchPostRequest request
    ) {
        postService.modifyPost(request.toServiceDto(jwtService.getMemberIdFromUserDetails(), postId));
        return new ResponseEntity<>(SUCCESS.getMessage(), SUCCESS.getStatus());
    }

    // 게시물 삭제 (soft delete)
    @Operation(summary = "게시물 삭제 API", description = "게시물을 삭제합니다. (Soft Delete)")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "요청이 성공적으로 처리되었습니다."),
            @ApiResponse(responseCode = "400", description = "잘못된 요청입니다.<br>" + "JWT를 입력해주세요.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "405", description = "허용되지 않은 메서드입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "내부 서버 오류입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "401", description = "유효하지 않은 JWT입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "404", description = "존재하지 않는 유저입니다.<br>" + "존재하지 않는 게시물입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @DeleteMapping("/{postId}")
    public ResponseEntity<String> deletePost(
            @PathVariable @Schema(description = "게시물 아이디를 입력해주세요.", example = "1") Long postId
    ) {
        postService.deletePost(DeletePostServiceDto.of(jwtService.getMemberIdFromUserDetails(), postId));
        return new ResponseEntity<>(SUCCESS.getMessage(), SUCCESS.getStatus());
    }

    // 댓글 작성
    @Operation(summary = "댓글 생성 API", description = "새 댓글을 작성합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "요청이 성공적으로 처리되었습니다."),
            @ApiResponse(responseCode = "400", description = "잘못된 요청입니다.<br>" + "JWT를 입력해주세요.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "405", description = "허용되지 않은 메서드입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "내부 서버 오류입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "401", description = "유효하지 않은 JWT입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "404", description = "존재하지 않는 유저입니다.<br>" + "존재하지 않는 게시물입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PostMapping("/{postId}/comment")
    public ResponseEntity<String> createComment(
            @PathVariable @Schema(description = "게시물 아이디를 입력해주세요.", example = "1") Long postId,
            @RequestBody @Valid PostCommentRequest request
    ) {
        postService.createComment(request.toServiceDto(jwtService.getMemberIdFromUserDetails(), postId));
        return new ResponseEntity<>(SUCCESS.getMessage(), SUCCESS.getStatus());
    }

    // 댓글 수정
    @Operation(summary = "댓글 수정 API", description = "댓글을 수정합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "요청이 성공적으로 처리되었습니다."),
            @ApiResponse(responseCode = "400", description = "잘못된 요청입니다.<br>" + "JWT를 입력해주세요.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "405", description = "허용되지 않은 메서드입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "내부 서버 오류입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "401", description = "유효하지 않은 JWT입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "404", description = "존재하지 않는 유저입니다.<br>" + "존재하지 않는 게시물입니다.<br>" + "존재하지 않는 댓글입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PatchMapping("/{postId}/comments/{commentId}")
    public ResponseEntity<String> modifyComment(
            @PathVariable @Schema(description = "게시물 아이디를 입력해주세요.", example = "1") Long postId,
            @PathVariable @Schema(description = "댓글 아이디를 입력해주세요.", example = "1") Long commentId,
            @RequestBody @Valid PatchCommentRequest request
    ) {
        postService.modifyComment(request.toServiceDto(jwtService.getMemberIdFromUserDetails(), postId, commentId));
        return new ResponseEntity<>(SUCCESS.getMessage(), SUCCESS.getStatus());
    }

    // 댓글 삭제 (soft delete)
    @Operation(summary = "댓글 삭제 API", description = "댓글을 삭제합니다. (Soft Delete)")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "요청이 성공적으로 처리되었습니다."),
            @ApiResponse(responseCode = "400", description = "잘못된 요청입니다.<br>" + "JWT를 입력해주세요.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "405", description = "허용되지 않은 메서드입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "내부 서버 오류입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "401", description = "유효하지 않은 JWT입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "404", description = "존재하지 않는 유저입니다.<br>" + "존재하지 않는 게시물입니다.<br>" + "존재하지 않는 댓글입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @DeleteMapping("/{postId}/comments/{commentId}")
    public ResponseEntity<String> deleteComment(
            @PathVariable @Schema(description = "게시물 아이디를 입력해주세요.", example = "1") Long postId,
            @PathVariable @Schema(description = "댓글 아이디를 입력해주세요.", example = "1") Long commentId
    ) {
        postService.deleteComment(DeleteCommentServiceDto.of(jwtService.getMemberIdFromUserDetails(), postId, commentId));
        return new ResponseEntity<>(SUCCESS.getMessage(), SUCCESS.getStatus());
    }
}
