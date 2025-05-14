package org.sopt.collaboration.domain.club.service.util;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum DeadlineType {
	UNDER7(7),
	OVER7(7),
	OVER14(14),
	OVER30(30);

	private final int day;
}
