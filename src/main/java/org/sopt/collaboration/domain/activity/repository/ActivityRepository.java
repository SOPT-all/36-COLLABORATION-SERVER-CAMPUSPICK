package org.sopt.collaboration.domain.activity.repository;

import java.util.List;

import org.sopt.collaboration.domain.activity.entity.ActivityRecruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends JpaRepository<ActivityRecruit, Long> {
	List<ActivityRecruit> findTop5ByOrderByViewCountDesc();
}
