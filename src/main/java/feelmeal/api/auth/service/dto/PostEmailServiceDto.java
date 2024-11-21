package feelmeal.api.auth.service.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostEmailServiceDto {
    private String email;

    @Builder
    public PostEmailServiceDto(String email) {
        this.email = email;
    }
}
