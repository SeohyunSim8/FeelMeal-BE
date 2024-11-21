package feelmeal.api.d.controller;

import feelmeal.api.d.service.ThemeService;
import feelmeal.global.common.jwt.JwtService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name = "[Menu]", description = "방탈출 테마 관련 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/themes")
public class ThemeController {
    private final ThemeService themeService;

}
