package feelmeal.api.auth.controller;

import feelmeal.api.auth.controller.dto.request.PostLoginRequest;
import feelmeal.api.auth.controller.dto.request.PostSignUpRequest;
import feelmeal.api.auth.controller.dto.response.PostLoginResponse;
import feelmeal.api.auth.controller.dto.response.PostSignUpResponse;
import feelmeal.api.auth.service.AuthService;
import feelmeal.global.annotation.NonAuth;
import feelmeal.global.common.exception.ErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static feelmeal.global.common.exception.ResponseCode.SUCCESS;

@Tag(name = "[Auth]", description = "회원가입 및 로그인 API")
@Slf4j
@RequiredArgsConstructor
@RestController("/auth")
public class AuthController {
    private final AuthService authService;

    @NonAuth
    @Operation(summary = "회원가입 API", description = "회원가입을 진행한다")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "요청이 성공적으로 처리되었습니다."),
            @ApiResponse(responseCode = "400", description = "잘못된 요청입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "405", description = "허용되지 않은 메서드입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "내부 서버 오류입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "409", description = "이미 가입된 유저입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PostMapping("/sign-up")
    public ResponseEntity<PostSignUpResponse> signUp(
            @Valid @RequestBody PostSignUpRequest request
    ) {
        PostSignUpResponse response = authService.signUp(request.toServiceDto());
        return new ResponseEntity<>(response, SUCCESS.getStatus());
    }

    @NonAuth
    @Operation(summary = "로그인 API", description = "로그인을 진행한다")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "요청이 성공적으로 처리되었습니다."),
            @ApiResponse(responseCode = "400", description = "잘못된 요청입니다.<br>" + "비밀번호가 일치하지 않습니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "405", description = "허용되지 않은 메서드입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "내부 서버 오류입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "404", description = "존재하지 않는 유저입니다.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PostMapping("/login")
    public ResponseEntity<PostLoginResponse> login(
            @Valid @RequestBody PostLoginRequest request
    ) {
        PostLoginResponse response = authService.login(request.toServiceDto());
        return new ResponseEntity<>(response, SUCCESS.getStatus());
    }

}