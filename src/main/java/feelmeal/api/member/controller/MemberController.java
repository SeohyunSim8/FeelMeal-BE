package feelmeal.api.member.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import feelmeal.api.member.controller.dto.request.PatchMemberInfoRequest;
import feelmeal.api.member.controller.dto.response.GetMemberInfoResponse;
import feelmeal.api.member.service.MemberService;
import feelmeal.api.member.service.dto.GetMemberServiceDto;
import feelmeal.api.member.controller.dto.response.GetReviewMemberInfoResponse;
import feelmeal.api.member.service.dto.GetReviewMemberServiceDto;
import feelmeal.global.common.exception.ErrorResponse;
import feelmeal.global.common.jwt.JwtService;

import static feelmeal.global.common.exception.ResponseCode.SUCCESS;

@Tag(name = "[Member]", description = "내 정보 관련 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {
    private final MemberService memberService;
    private final JwtService jwtService;

    @Operation(summary = "내 정보 조회 API", description = "내 정보 조회를 진행한다")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "요청이 성공적으로 처리되었습니다."),
            @ApiResponse(responseCode = "400", description = "잘못된 요청입니다.<br>" + "JWT를 입력해주세요.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "405", description = "허용되지 않은 메서드입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "내부 서버 오류입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "401", description = "유효하지 않은 JWT입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "404", description = "존재하지 않는 유저입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping("/info")
    public ResponseEntity<GetMemberInfoResponse> getMemberInfo() {
        Long memberId = jwtService.getMemberIdFromUserDetails();
        GetMemberInfoResponse response = memberService.getMemberInfo(GetMemberServiceDto.of(memberId));
        return new ResponseEntity<>(response, SUCCESS.getStatus());
    }

    @Operation(summary = "내 정보 수정 API", description = "내 정보 조회를 진행한다")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "요청이 성공적으로 처리되었습니다."),
            @ApiResponse(responseCode = "400", description = "잘못된 요청입니다.<br>" + "JWT를 입력해주세요.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "405", description = "허용되지 않은 메서드입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "내부 서버 오류입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "401", description = "유효하지 않은 JWT입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "404", description = "존재하지 않는 유저입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PatchMapping("/info")
    public ResponseEntity<String> updateMemberInfo(
        @Valid @RequestBody PatchMemberInfoRequest request
    ) {
        Long memberId = jwtService.getMemberIdFromUserDetails();
        memberService.updateMemberInfo(request.toServiceDto(memberId));
        return new ResponseEntity<>(SUCCESS.getMessage(), SUCCESS.getStatus());
    }

    @Operation(summary = "유저 기본 정보 조회 API", description = "유저 기본 정보 조회를 진행한다")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "요청이 성공적으로 처리되었습니다."),
            @ApiResponse(responseCode = "400", description = "잘못된 요청입니다.<br>" + "JWT를 입력해주세요.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "405", description = "허용되지 않은 메서드입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "내부 서버 오류입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "401", description = "유효하지 않은 JWT입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "404", description = "존재하지 않는 유저입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping("/review-info")
    public ResponseEntity<GetReviewMemberInfoResponse> getReviewMemberInfo() {
        Long memberId = jwtService.getMemberIdFromUserDetails();
        GetReviewMemberInfoResponse response = memberService.getReviewMemberInfo(GetReviewMemberServiceDto.of(memberId));
        return new ResponseEntity<>(response, SUCCESS.getStatus());
    }
}
