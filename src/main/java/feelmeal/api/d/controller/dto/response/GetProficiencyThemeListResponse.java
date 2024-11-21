package feelmeal.api.d.controller.dto.response;

import feelmeal.global.common.response.PageResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetProficiencyThemeListResponse {
    @Schema(description = "숙련도 이름", example = "방린이")
    private String profName;

    @Schema(description = "숙련도 설명", example = "방탈출을 한 번도 해보지 않은 여러분들을 위해 대부분 가볍게 즐길 수 있는 테마로 준비했으며, 거의 모두가 쉽게 탈출할 수 있는 테마로 준비하였습니다!")
    private String profDescription;
    
    private PageResponse<GetProficiencyTheme> proficiencyDataList;

    @Builder
    public GetProficiencyThemeListResponse(String profName, String profDescription, PageResponse<GetProficiencyTheme> proficiencyDataList) {
        this.profName = profName;
        this.profDescription = profDescription;
        this.proficiencyDataList = proficiencyDataList;
    }

    public static GetProficiencyThemeListResponse of(String profName, String profDescription, PageResponse<GetProficiencyTheme> proficiencyDataList) {
        return GetProficiencyThemeListResponse.builder()
                .profName(profName)
                .profDescription(profDescription)
                .proficiencyDataList(proficiencyDataList)
                .build();
    }
}
