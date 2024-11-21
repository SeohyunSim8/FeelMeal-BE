package feelmeal.api.auth.service;

import feelmeal.api.auth.controller.dto.response.PostLoginResponse;
import feelmeal.api.auth.service.dto.PostEmailServiceDto;
import feelmeal.api.auth.service.dto.PostLoginServiceDto;
import feelmeal.api.auth.service.dto.PostNicknameServiceDto;
import feelmeal.api.auth.service.dto.PostSignUpServiceDto;

public interface AuthService {
    void signUp(PostSignUpServiceDto dto);

    void checkNickname(PostNicknameServiceDto dto);

    void checkEmail(PostEmailServiceDto serviceDto);

    PostLoginResponse login(PostLoginServiceDto dto);
}
