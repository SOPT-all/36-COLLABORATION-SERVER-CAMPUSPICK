package org.sopt.collaboration.domain.club.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ClubDay {
	MONDAY("월요일"),
	TUESDAY("화요일"),
	WEDNESDAY("수요일"),
	THURSDAY("목요일"),
	FRIDAY("금요일"),
	WEEKEND("주말");

	private final String name;
}
