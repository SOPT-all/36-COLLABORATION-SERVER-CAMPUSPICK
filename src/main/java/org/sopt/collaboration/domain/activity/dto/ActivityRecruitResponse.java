package org.sopt.collaboration.domain.activity.dto;

import org.sopt.collaboration.domain.activity.entity.ActivityRecruit;

public record ActivityRecruitResponse(String title, int viewCount, int commentCount, String image) {

	public static ActivityRecruitResponse from(ActivityRecruit activityRecruit) {
		return new ActivityRecruitResponse(
			activityRecruit.getTitle(),
			activityRecruit.getViewCount(),
			activityRecruit.getCommentCount(),
			activityRecruit.getImage());
	}
}
