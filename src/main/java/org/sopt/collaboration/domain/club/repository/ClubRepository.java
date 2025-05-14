package org.sopt.collaboration.domain.club.repository;

import org.sopt.collaboration.domain.club.entity.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClubRepository extends JpaRepository<Club, Long> {
	List<Club> findTop3ByOrderByLikeCountDesc();
}
