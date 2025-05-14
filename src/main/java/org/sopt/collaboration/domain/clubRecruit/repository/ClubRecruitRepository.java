package org.sopt.collaboration.domain.clubRecruit.repository;

import org.sopt.collaboration.domain.club.entity.ClubRecruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClubRecruitRepository extends JpaRepository<ClubRecruit, Long> {
    List<ClubRecruit> findTop5ByOrderByViewCountDesc();
}
