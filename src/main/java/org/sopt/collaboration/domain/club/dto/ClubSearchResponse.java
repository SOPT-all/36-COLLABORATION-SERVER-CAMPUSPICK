package org.sopt.collaboration.domain.club.dto;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.sopt.collaboration.domain.club.entity.Club;
import org.sopt.collaboration.domain.club.entity.ClubRecruit;

public record ClubSearchResponse(ClubInfo clubInfo, RecruitPost recruitPost) {
	public record ClubInfo(long id, String name, String image) {
		public ClubInfo(Club club) {
			this(club.getId(), club.getName(), club.getImage());
		}
	}

	public record RecruitPost(
		long id,
		String title,
		String image,
		int viewCount,
		int commentCount,
		long dDay
	) {
		public RecruitPost(ClubRecruit clubRecruit) {
			this(
				clubRecruit.getId(),
				clubRecruit.getTitle(),
				clubRecruit.getImage(),
				clubRecruit.getViewCount(),
				clubRecruit.getCommentCount(),
				ChronoUnit.DAYS.between(LocalDate.now(), clubRecruit.getRecruitDeadline())
			);
		}
	}

	public static ClubSearchResponse from(ClubRecruit clubRecruit) {
		return new ClubSearchResponse(
			new ClubInfo(clubRecruit.getClub()),
			new RecruitPost(clubRecruit)
		);
	}
}
