package org.sopt.collaboration.domain.club.controller;

import lombok.RequiredArgsConstructor;

import org.sopt.collaboration.domain.club.dto.ClubDto;
import org.sopt.collaboration.domain.club.service.ClubService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/clubs")
public class ClubController {
	private final ClubService clubService;

	@GetMapping("/rank")
	public List<ClubDto> getClubsByLikes() {
		return clubService.getClubsByLikesDesc();
	}
}
