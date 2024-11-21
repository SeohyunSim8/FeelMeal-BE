package feelmeal.api.member.service;

import feelmeal.api.member.controller.dto.response.GetMemberInfoResponse;
import feelmeal.api.member.controller.dto.response.GetReviewMemberInfoResponse;
import feelmeal.api.member.service.dto.GetMemberServiceDto;
import feelmeal.api.member.service.dto.GetReviewMemberServiceDto;
import feelmeal.api.member.service.dto.PatchMemberInfoServiceDto;

public interface MemberService {
    GetMemberInfoResponse getMemberInfo(GetMemberServiceDto dto);

    void updateMemberInfo(PatchMemberInfoServiceDto dto);

    GetReviewMemberInfoResponse getReviewMemberInfo(GetReviewMemberServiceDto dto);
}
