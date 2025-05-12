package org.sopt.collaboration.domain.club.entity;

import java.time.LocalDate;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "club_recruit")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ClubRecruit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "title", nullable = false)
	private String title;

	@Column(name = "view_count", nullable = false)
	private int viewCount;

	@Column(name = "comment_count", nullable = false)
	private int commentCount;

	@Column(name = "recruit_deadline", nullable = false)
	private LocalDate recruitDeadline;

	@CreatedDate
	@Column(name = "created_date", nullable = false)
	private LocalDate createdDate;

	@Column(name = "image", nullable = false)
	private String image;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "club_id")
	private Club club;

	@Builder
	private ClubRecruit(String title, int viewCount, int commentCount, LocalDate recruitDeadline, LocalDate createdDate,
		String image, Club club) {
		this.title = title;
		this.viewCount = viewCount;
		this.commentCount = commentCount;
		this.recruitDeadline = recruitDeadline;
		this.createdDate = createdDate;
		this.image = image;
		this.club = club;
	}
}
