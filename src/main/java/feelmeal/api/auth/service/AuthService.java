package feelmeal.api.auth.service;

import feelmeal.api.auth.controller.dto.response.PostLoginResponse;
import feelmeal.api.auth.controller.dto.response.PostSignUpResponse;
import feelmeal.api.auth.service.dto.PostLoginServiceDto;
import feelmeal.api.auth.service.dto.PostSignUpServiceDto;

public interface AuthService {
    PostSignUpResponse signUp(PostSignUpServiceDto dto);

    PostLoginResponse login(PostLoginServiceDto dto);
}
