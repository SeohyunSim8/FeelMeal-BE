package feelmeal.api.theme.service;

import feelmeal.api.theme.controller.dto.response.*;
import feelmeal.api.theme.service.dto.*;
import feelmeal.global.common.response.PageResponse;

import java.util.List;

public interface ThemeService {
    PageResponse<GetLocationThemeListResponse> getLocationThemeList(GetLocationThemeListServiceDto dto);

    GetProficiencyThemeListResponse getProficiencyThemeList(GetProficiencyThemeListServiceDto dto);

    PageResponse<GetGenreThemeListResponse> getGenreThemeList(GetGenreThemeListServiceDto dto);

    PageResponse<GetThemeLikedListResponse> getThemeLikedList(GetThemeLikedListServiceDto dto);

    void createThemeLike(PostThemeLikeServiceDto dto);

    void deleteThemeLike(DeleteThemeLikeServiceDto dto);

    List<GetOverallReviewListResponse> getOverallReviewList();

    List<GetLocationStationListResponse> getStationList();

    List<GetGenreListResponse> getGenreList();

    GetReviewThemeInfoResponse getReviewThemeInfo(GetThemeInfoServiceDto dto);
}
