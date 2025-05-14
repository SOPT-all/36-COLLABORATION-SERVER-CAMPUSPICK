package org.sopt.collaboration.domain.club.controller;

import lombok.RequiredArgsConstructor;

import org.sopt.collaboration.domain.club.dto.ClubDto;
import org.sopt.collaboration.domain.club.dto.ClubRecruitDto;
import org.sopt.collaboration.domain.club.dto.ClubSearchResponse;
import org.sopt.collaboration.domain.club.entity.enums.ClubCategory;
import org.sopt.collaboration.domain.club.entity.enums.ClubDay;
import org.sopt.collaboration.domain.club.entity.enums.ClubRegion;
import org.sopt.collaboration.domain.club.service.ClubService;
import org.sopt.collaboration.domain.club.service.util.DeadlineType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/clubs")
public class ClubController {
	private final ClubService clubService;

	@GetMapping(path = "/rank")
	public List<ClubDto> getClubsByLikes() {
		return clubService.getClubsByLikesDesc();
	}

	@GetMapping(path = "/popular")
	public List<ClubRecruitDto> getClubRecruitByViewCount() {
		return clubService.getClubRecruitByViewCount();
	}

	@GetMapping(path = "/search")
	public List<ClubSearchResponse> searchClubs(
		@RequestParam(name = "keyword", required = false) final String keyword,
		@RequestParam(name = "deadlineType", required = false) final DeadlineType deadlineType,
		@RequestParam(name = "category", required = false) final ClubCategory category,
		@RequestParam(name = "region", required = false) final ClubRegion region,
		@RequestParam(name = "clubDay", required = false) final ClubDay clubDay
	) {
		return clubService.findClubRecruitByCondition(keyword, deadlineType, category, region, clubDay);
	}
}
