package feelmeal.api.auth.service;

import feelmeal.api.auth.controller.dto.response.PostLoginResponse;
import feelmeal.api.auth.controller.dto.response.PostSignUpResponse;
import feelmeal.api.auth.service.dto.PostLoginServiceDto;
import feelmeal.api.auth.service.dto.PostSignUpServiceDto;
import feelmeal.api.member.service.MemberServiceImpl;
import feelmeal.domain.member.entity.Member;
import feelmeal.domain.member.repository.MemberRepository;
import feelmeal.global.common.entity.Constant;
import feelmeal.global.common.exception.CustomException;
import feelmeal.global.common.exception.ResponseCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static feelmeal.global.common.exception.ResponseCode.INVALID_PASSWORD;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {
    MemberServiceImpl memberService;

    private final MemberRepository memberRepository;

    // 회원가입 API
    @Transactional
    public PostSignUpResponse signUp(PostSignUpServiceDto dto) {
        // 이미 존재하는 멤버인지 확인한다
        Optional<Member> existMember = memberService.findOptionalMemberById(dto.getId(), Constant.Status.ACTIVE);
        if (existMember.isPresent()) throw new CustomException(ResponseCode.EXIST_MEMBER);

        // 존재하지 않는 멤버라면 회원가입을 진행한다
        memberRepository.save(Member.builder()
                .id(dto.getId())
                .pw(dto.getPassword())
                .name(dto.getName())
                .address(dto.getAddress())
                .build());

        // 멤버 고유번호 반환
        Member member = memberService.findMemberById(dto.getId(), Constant.Status.ACTIVE);
        return PostSignUpResponse.of(member.getIdx());
    }

    // 로그인 API
    public PostLoginResponse login(PostLoginServiceDto dto) {
        // 회원가입된 멤버인지 확인한다
        Member member = memberService.findMemberById(dto.getId(), Constant.Status.ACTIVE);

        // 비밀번호가 일치하는지 확인한다
        if(dto.getPassword().matches(member.getPw())) throw new CustomException(INVALID_PASSWORD);

        return PostLoginResponse.of(member.getIdx());
    }
}
