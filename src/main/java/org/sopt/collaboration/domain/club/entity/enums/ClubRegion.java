package org.sopt.collaboration.domain.club.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ClubRegion {
	CAPITAL_REGION("수도권"),
	CHUNGCHEONG_DAEJEON("충북/충남/대전"),
	JEONBUK("전북"),
	JEONNAM_GWANGJU("전남/광주"),
	GYEONGBUK_DAEGU("경북/대구"),
	GYEONGNAM_BUSAN_ULSAN("경남/부산/울산"),
	GANGWON("강원"),
	JEJU("제주"),
	ETC("기타");

	private final String regionName;

}
