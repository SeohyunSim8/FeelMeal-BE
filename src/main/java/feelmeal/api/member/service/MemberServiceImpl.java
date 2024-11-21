package feelmeal.api.member.service;

import feelmeal.api.member.controller.dto.response.GetMemberInfoResponse;
import feelmeal.api.member.controller.dto.response.GetReviewMemberInfoResponse;
import feelmeal.api.member.service.dto.GetMemberServiceDto;
import feelmeal.api.member.service.dto.GetReviewMemberServiceDto;
import feelmeal.api.member.service.dto.PatchMemberInfoServiceDto;
import feelmeal.domain.member.entity.Member;
import feelmeal.domain.member.repository.MemberRepository;
import feelmeal.global.common.entity.BaseEntity;
import feelmeal.global.common.entity.Constant;
import feelmeal.global.common.exception.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static feelmeal.global.common.exception.ResponseCode.NOT_FOUND_MEMBER;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * 내 정보 조회 API
     */
    public GetMemberInfoResponse getMemberInfo(GetMemberServiceDto dto) {
        // 멤버를 조회한다
        Member member = findEntityById(dto.getMemberId(), BaseEntity.Status.ACTIVE);
        return GetMemberInfoResponse.of(member.getId(), member.getNickname(), member.getEmail(), member.getProfileImgUrl());
    }

    /**
     * 내 정보 수정 API
     */
    @Transactional
    public void updateMemberInfo(PatchMemberInfoServiceDto dto) {
        // 멤버를 조회한다
        Member member = findEntityById(dto.getMemberId(), BaseEntity.Status.ACTIVE);

        // 비밀번호 암호화 후 멤버 업데이트를 진행한다
        dto.encryptPassword(bCryptPasswordEncoder.encode(dto.getPassword()));
        member.updateMemberInfo(dto);
    }

    public Member findEntityById(Long memberId, BaseEntity.Status status) {
//        return memberRepository.findByIdAndStatus(memberId, status)
//                .orElseThrow(() -> new CustomException(NOT_FOUND_USER));
    }

    /**
     * 리뷰 유저 기본 정보 조회 API
     * @return GetReviewMemberInfoResponse
     */
    public GetReviewMemberInfoResponse getReviewMemberInfo(GetReviewMemberServiceDto dto) {
        // 멤버를 조회한다
        Member member = findEntityById(dto.getMemberId(), BaseEntity.Status.ACTIVE);

        // 후기 작성을 위한 유저 기본 정보를 반환한다
        return GetReviewMemberInfoResponse.of(member.getId(), member.getNickname(), member.getProfileImgUrl(),
                member.getProficiency(), member.getHorrorPos(), member.getGenre(), member.getAbout());
    }

    public Member findMemberById(String id, Constant.Status status) {
        return memberRepository.findByIdAndStatus(id, status)
                .orElseThrow(() -> new CustomException(NOT_FOUND_MEMBER));
    }

    public Optional<Member> findOptionalMemberById(String id, Constant.Status status) {
        return memberRepository.findByIdAndStatus(id, status);
    }

    public Member findMemberByIdx(Long idx, Constant.Status status) {
        return memberRepository.findByIdxAndStatus(idx, status)
                .orElseThrow(() -> new CustomException(NOT_FOUND_MEMBER));
    }
}
