package feelmeal.api.member.controller.dto.request;

import feelmeal.api.member.service.dto.PatchMemberInfoServiceDto;
import feelmeal.global.common.entity.Constant;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PatchMemberInfoRequest {
    @NotBlank
    @Schema(description = "닉네임", example = "보리")
    private String nickname;

    @NotBlank
    @Email
    @Schema(description = "이메일", example = "feelmeal@gmail.com")
    private String email;

    @Pattern(regexp = "^[a-zA-Z0-9]+$")
    @Size(min = 12, max = 30)
    @NotBlank
    @Schema(description = "비밀번호", example = "1234")
    private String password;

    @NotNull
    @Schema(description = "숙련도 (BEGINNER: 방린이, JUNIOR: 방초보, SENIOR: 방준수, MASTER: 방고인물)", example = "BEGINNER")
    private Constant.Proficiency proficiency;

    @NotNull
    @Schema(description = "공포테마 포지션 (FEARLESS: 탱, FEARFUL_TANK: 쫄탱, RELUCTANT_TANK: 마지모탱, NERVOUS: 변쫄, SCARED: 쫄, EXTREME_SCARED: 쫄)", example = "FEARLESS")
    private Constant.HorrorPos horrorPos;

    @NotNull
    @Schema(description = "선호장르 (SENTIMENTAL: 감성, HORROR: 공포, DETECTIVE: 추리, THRILLER: 스릴러, COMIC: 코믹, MYSTERY: 미스터리, FANTASY: 판타지, ADVENTURE: 어드벤처, ETC: 기타)", example = "SENTIMENTAL")
    private Constant.Genre genre;

    @Schema(description = "플레이어 성향", example = "장르 편식 없음")
    private String about;

    public PatchMemberInfoServiceDto toServiceDto(Long memberId) {
        return PatchMemberInfoServiceDto.builder()
                .memberId(memberId)
                .nickname(nickname)
                .email(email)
                .password(password)
                .proficiency(proficiency)
                .horrorPos(horrorPos)
                .genre(genre)
                .about(about)
                .build();
    }
}
