package org.sopt.collaboration.domain.club.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import org.sopt.collaboration.domain.club.entity.Club;

@Getter
@NoArgsConstructor
public class ClubDto {
	private long id;
	private String clubName;
	private String clubIntroduce;
	private String clubImage;

	// DTO 변환용 생성자
	public ClubDto(Club club) {
		this.id = club.getId();
		this.clubName = club.getName();
		this.clubIntroduce = club.getIntroduce();
		this.clubImage = club.getImage();
	}
}
