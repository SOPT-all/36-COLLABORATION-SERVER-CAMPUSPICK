package org.sopt.collaboration.domain.club.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ClubCategory {
	CULTURE("문화/예술/공연"),
	VOLUNTEER("봉사/사회활동"),
	ACADEMIC("학술/교양"),
	JOB("취업/창업"),
	LANGUAGE("어학"),
	SPORTS("체육"),
	SOCIAL("친목"),
	ETC("기타");

	private final String name;
}
