package org.sopt.collaboration.domain.activity.service;

import java.util.List;

import org.sopt.collaboration.domain.activity.dto.ActivityRecruitResponse;
import org.sopt.collaboration.domain.activity.repository.ActivityRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ActivityService {
	private final ActivityRepository activityRepository;

	public List<ActivityRecruitResponse> getPopularActivities() {
		return activityRepository.findTop5ByOrderByViewCountDesc()
			.stream()
			.map(ActivityRecruitResponse::from)
			.toList();
	}
}
