package org.sopt.collaboration.domain.clubRecruit.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.sopt.collaboration.domain.club.dto.ClubDto;
import org.sopt.collaboration.domain.club.entity.Club;
import org.sopt.collaboration.domain.club.entity.ClubRecruit;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class ClubRecruitDto {
    private Long id;
    private String title;
    private int viewCount;
    private int commentCount;
    private LocalDate recruitDeadline;
    private String image;
    private LocalDate createdDate;
    private long club;

    public ClubRecruitDto(ClubRecruit clubRecruit) {
        this.title = clubRecruit.getTitle();
        this.recruitDeadline = clubRecruit.getRecruitDeadline();
        this.viewCount = clubRecruit.getViewCount();
        this.commentCount = clubRecruit.getCommentCount();
        this.image = clubRecruit.getImage();
        this.club = clubRecruit.getClub().getId();
    }
}
