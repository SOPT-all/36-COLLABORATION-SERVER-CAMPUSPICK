package org.sopt.collaboration.domain.activity.entity;

import java.time.LocalDate;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "activity_recruit")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ActivityRecruit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "title", nullable = false)
	private String title;

	@Column(name = "view_count", nullable = false)
	private int viewCount;

	@Column(name = "comment_count", nullable = false)
	private int commentCount;

	@Column(name = "image", nullable = false)
	private String image;

	@CreatedDate
	@Column(name = "created_date", nullable = false)
	private LocalDate createdDate;

	@Builder
	private ActivityRecruit(String title, int viewCount, int commentCount, String image, LocalDate createdDate) {
		this.title = title;
		this.viewCount = viewCount;
		this.commentCount = commentCount;
		this.image = image;
		this.createdDate = createdDate;
	}
}
