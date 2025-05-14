package org.sopt.collaboration.domain.club.service;

import lombok.RequiredArgsConstructor;

import org.sopt.collaboration.domain.club.dto.ClubDto;
import org.sopt.collaboration.domain.club.dto.ClubRecruitDto;
import org.sopt.collaboration.domain.club.dto.ClubSearchResponse;
import org.sopt.collaboration.domain.club.entity.ClubRecruit;
import org.sopt.collaboration.domain.club.entity.enums.ClubCategory;
import org.sopt.collaboration.domain.club.entity.enums.ClubDay;
import org.sopt.collaboration.domain.club.entity.enums.ClubRegion;
import org.sopt.collaboration.domain.club.repository.ClubRecruitRepository;
import org.sopt.collaboration.domain.club.repository.ClubRepository;
import org.sopt.collaboration.domain.club.service.util.DeadlineType;
import org.sopt.collaboration.domain.club.service.util.DeadlineUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ClubService {
	private final ClubRepository clubRepository;
	private final ClubRecruitRepository clubRecruitRepository;

	public List<ClubDto> getClubsByLikesDesc() {
		return clubRepository.findTop3ByOrderByLikeCountDesc()
			.stream()
			.map(ClubDto::new)
			.toList();
	}

	public List<ClubRecruitDto> getClubRecruitByViewCount() {
		return clubRecruitRepository.findTop5ByOrderByViewCountDesc()
			.stream()
			.map(ClubRecruitDto::new)
			.toList();
	}

	public List<ClubSearchResponse> findClubRecruitByCondition(
		final String keyword,
		final DeadlineType deadlineType,
		final ClubCategory category,
		final ClubRegion region,
		final ClubDay clubDay) {
		List<ClubRecruit> clubRecruits = clubRecruitRepository.findClubRecruitsBy(
			keyword,
			DeadlineUtil.getAfterDeadline(deadlineType),
			DeadlineUtil.getBeforeDeadline(deadlineType),
			category,
			region,
			clubDay
		);

		return clubRecruits.stream().map(ClubSearchResponse::from).toList();
	}
}
