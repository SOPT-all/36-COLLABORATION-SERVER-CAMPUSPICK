package org.sopt.collaboration.domain.activity.controller;

import java.util.List;

import org.sopt.collaboration.domain.activity.dto.ActivityRecruitResponse;
import org.sopt.collaboration.domain.activity.service.ActivityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/activities")
public class ActivityController {
	private final ActivityService activityService;

	@GetMapping(path = "/popular")
	public List<ActivityRecruitResponse> getPopularActivities() {
		return activityService.getPopularActivities();
	}
}
