package feelmeal.api.auth.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import feelmeal.api.auth.controller.dto.response.PostLoginResponse;
import feelmeal.api.auth.service.dto.PostEmailServiceDto;
import feelmeal.api.auth.service.dto.PostLoginServiceDto;
import feelmeal.api.auth.service.dto.PostNicknameServiceDto;
import feelmeal.api.auth.service.dto.PostSignUpServiceDto;
import feelmeal.domain.member.entity.Member;
import feelmeal.domain.member.repository.MemberRepository;
import feelmeal.global.common.entity.BaseEntity;
import feelmeal.global.common.exception.CustomException;
import feelmeal.global.common.exception.ResponseCode;
import feelmeal.global.common.jwt.JwtService;

import java.util.Optional;

import static feelmeal.global.common.exception.ResponseCode.INVALID_PASSWORD;
import static feelmeal.global.common.exception.ResponseCode.NOT_FOUND_USER;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {
    private final MemberRepository memberRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final JwtService jwtService;


    /**
     * 회원가입 API
     */
    @Transactional
    public void signUp(PostSignUpServiceDto dto) {
        // 이미 존재하는 유저인지 확인을 진행한다
        Optional<Member> existMember = findEntityByEmailOp(dto.getEmail(), BaseEntity.Status.ACTIVE);
        if (existMember.isPresent()) throw new CustomException(ResponseCode.EXIST_USER);

        // 존재하지 않는 유저라면 회원가입을 진행한다
        memberRepository.save(Member.builder()
                .email(dto.getEmail())
                .pw(bCryptPasswordEncoder.encode(dto.getPassword()))
                .nickname(dto.getNickname())
                .about(dto.getAbout())
                .proficiency(dto.getProficiency())
                .horrorPos(dto.getHorrorPos())
                .genre(dto.getGenre())
                .build());
    }

    /**
     * 닉네임 중복 검사 API
     */
    @Override
    public void checkNickname(PostNicknameServiceDto dto) {
        // 이미 해당 닉네임을 가진 유저가 있으면 예외 처리를 진행한다
        Optional<Member> member = memberRepository.findByNicknameAndStatus(dto.getNickname(), BaseEntity.Status.ACTIVE);
        if (member.isPresent()) throw new CustomException(ResponseCode.EXIST_USER);
    }

    /**
     * 이메일 중복 검사 API
     */
    @Override
    public void checkEmail(PostEmailServiceDto dto) {
        // 이미 해당 이메일을 가진 유저가 있으면 예외 처리를 진행한다
        Optional<Member> member = findEntityByEmailOp(dto.getEmail(), BaseEntity.Status.ACTIVE);
        if (member.isPresent()) throw new CustomException(ResponseCode.EXIST_USER);
    }

    /**
     * 로그인 API
     */
    public PostLoginResponse login(PostLoginServiceDto dto) {
        // 회원가입된 유저인지 확인한다
        Member member = findEntityByEmail(dto.getEmail(), BaseEntity.Status.ACTIVE);

        // 비밀번호가 일치하지 않는 경우 예외처리를 진행한다
        if(!bCryptPasswordEncoder.matches(dto.getPassword(), member.getPw())) {
            throw new CustomException(INVALID_PASSWORD);
        }

        return PostLoginResponse.of(member.getId(), jwtService.createJwt(member.getId()));
    }

    public Member findEntityByEmail(String email, BaseEntity.Status status) {
        return memberRepository.findByEmailAndStatus(email, status)
                .orElseThrow(() -> new CustomException(NOT_FOUND_USER));
    }

    public Optional<Member> findEntityByEmailOp(String email, BaseEntity.Status status) {
        return memberRepository.findByEmailAndStatus(email, status);
    }
}
