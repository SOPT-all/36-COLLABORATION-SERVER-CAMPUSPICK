package org.sopt.collaboration.domain.club.repository;

import org.sopt.collaboration.domain.club.entity.ClubRecruit;
import org.sopt.collaboration.domain.club.entity.enums.ClubCategory;
import org.sopt.collaboration.domain.club.entity.enums.ClubDay;
import org.sopt.collaboration.domain.club.entity.enums.ClubRegion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ClubRecruitRepository extends JpaRepository<ClubRecruit, Long> {
	List<ClubRecruit> findTop5ByOrderByViewCountDesc();

	@Query("""
		    SELECT cr FROM ClubRecruit cr
		    LEFT JOIN FETCH cr.club c
		    WHERE (:keyword IS NULL OR :keyword = ''
				    OR cr.title LIKE CONCAT('%', :keyword, '%')
				    OR c.name LIKE CONCAT('%', :keyword, '%')
				)
		    	AND (:category IS NULL OR :category = '' OR c.category = :category)
				AND (:region IS NULL OR :region = '' OR c.region = :region)
				AND (:clubDay IS NULL OR :clubDay = '' OR c.clubDay = :clubDay)
				AND (:deadlineAfter IS NULL OR cr.recruitDeadline >= :deadlineAfter)
		        AND (:deadlineBefore IS NULL OR cr.recruitDeadline <= :deadlineBefore)
		    ORDER BY cr.createdDate DESC
		""")
	List<ClubRecruit> findClubRecruitsBy(
		@Param("keyword") String keyword,
		@Param("deadlineAfter") LocalDate deadlineAfter,
		@Param("deadlineBefore") LocalDate deadlineBefore,
		@Param("category") ClubCategory category,
		@Param("region") ClubRegion region,
		@Param("clubDay") ClubDay clubDay
	);
}
