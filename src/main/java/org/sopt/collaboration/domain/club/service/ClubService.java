package org.sopt.collaboration.domain.club.service;

import lombok.RequiredArgsConstructor;

import org.sopt.collaboration.domain.club.dto.ClubDto;
import org.sopt.collaboration.domain.club.dto.ClubRecruitDto;
import org.sopt.collaboration.domain.club.repository.ClubRecruitRepository;
import org.sopt.collaboration.domain.club.repository.ClubRepository;
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
}