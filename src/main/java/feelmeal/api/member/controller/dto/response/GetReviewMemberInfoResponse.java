package feelmeal.api.member.controller.dto.response;

import feelmeal.global.common.entity.Constant;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetReviewMemberInfoResponse {
    @Schema(description = "멤버 아이디", example = "1")
    private Long memberId;

    @Schema(description = "닉네임", example = "보리")
    private String nickname;

    @Schema(description = "프로필 사진", example = "")
    private String profileImg;

    @Schema(description = "숙련도 (BEGINNER: 방린이, JUNIOR: 방초보, SENIOR: 방준수, MASTER: 방고인물)", example = "BEGINNER")
    private Constant.Proficiency proficiency;

    @Schema(description = "공포테마 포지션 (FEARLESS: 탱, FEARFUL_TANK: 쫄탱, RELUCTANT_TANK: 마지모탱, NERVOUS: 변쫄, SCARED: 쫄, EXTREME_SCARED: 쫄)", example = "FEARLESS")
    private Constant.HorrorPos horrorPos;

    @Schema(description = "선호장르 (SENTIMENTAL: 감성, HORROR: 공포, DETECTIVE: 추리, THRILLER: 스릴러, COMIC: 코믹, MYSTERY: 미스터리, FANTASY: 판타지, ADVENTURE: 어드벤처, ETC: 기타)", example = "SENTIMENTAL")
    private Constant.Genre genre;

    @Schema(description = "플레이어 성향", example = "장르 편식 없음")
    private String about;

    @Builder
    public GetReviewMemberInfoResponse(Long memberId, String nickname, String profileImg, Constant.Proficiency proficiency, Constant.HorrorPos horrorPos, Constant.Genre genre, String about) {
        this.memberId = memberId;
        this.nickname = nickname;
        this.profileImg = profileImg;
        this.proficiency = proficiency;
        this.horrorPos = horrorPos;
        this.genre = genre;
        this.about = about;
    }

    public static GetReviewMemberInfoResponse of(Long memberId, String nickname, String profileImg, Constant.Proficiency proficiency, Constant.HorrorPos horrorPos, Constant.Genre genre, String about) {
        return GetReviewMemberInfoResponse.builder()
                .memberId(memberId)
                .nickname(nickname)
                .profileImg(profileImg)
                .proficiency(proficiency)
                .horrorPos(horrorPos)
                .genre(genre)
                .about(about)
                .build();
    }
}
