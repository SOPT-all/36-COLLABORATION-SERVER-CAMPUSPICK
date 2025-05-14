package org.sopt.collaboration.domain.club.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import org.sopt.collaboration.domain.club.entity.ClubRecruit;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Getter
@NoArgsConstructor
public class ClubRecruitDto {
	private long id;
	private String title;
	private int viewCount;
	private int commentCount;
	private long dDay;
	private String image;

	public ClubRecruitDto(ClubRecruit clubRecruit) {
		this.id = clubRecruit.getId();
		this.title = clubRecruit.getTitle();
		this.viewCount = clubRecruit.getViewCount();
		this.commentCount = clubRecruit.getCommentCount();
		this.dDay = ChronoUnit.DAYS.between(LocalDate.now(), clubRecruit.getRecruitDeadline());
		this.image = clubRecruit.getImage();
	}
}
