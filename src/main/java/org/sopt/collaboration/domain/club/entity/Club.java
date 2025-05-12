package org.sopt.collaboration.domain.club.entity;

import org.sopt.collaboration.domain.club.entity.enums.ClubCategory;
import org.sopt.collaboration.domain.club.entity.enums.ClubDay;
import org.sopt.collaboration.domain.club.entity.enums.ClubRegion;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "club")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Club {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "introduce", nullable = false, columnDefinition = "TEXT")
	private String introduce;

	@Column(name = "image", nullable = false)
	private String image;

	@Column(name = "like_count", nullable = false)
	private int likeCount;

	@Enumerated(EnumType.STRING)
	@Column(name = "category", nullable = false)
	private ClubCategory category;

	@Enumerated(EnumType.STRING)
	@Column(name = "region", nullable = false)
	private ClubRegion region;

	@Enumerated(EnumType.STRING)
	@Column(name = "club_day", nullable = false)
	private ClubDay clubDay;

	@Builder
	private Club(String name, String introduce, String image, int likeCount, ClubCategory category, ClubRegion region,
		ClubDay clubDay) {
		this.name = name;
		this.introduce = introduce;
		this.image = image;
		this.likeCount = likeCount;
		this.category = category;
		this.region = region;
		this.clubDay = clubDay;
	}
}
