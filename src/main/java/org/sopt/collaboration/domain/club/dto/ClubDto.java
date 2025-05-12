package org.sopt.collaboration.domain.club.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.sopt.collaboration.domain.club.entity.Club;
import org.sopt.collaboration.domain.club.entity.enums.ClubCategory;
import org.sopt.collaboration.domain.club.entity.enums.ClubDay;
import org.sopt.collaboration.domain.club.entity.enums.ClubRegion;

@Getter
@NoArgsConstructor
public class ClubDto {
    private Long id;
    private String clubName;
    private String clubIntroduce;
    private String clubImage;
    private ClubCategory category;
    private ClubRegion region;
    private ClubDay clubDay;
    private int likeCount;


    // DTO 변환용 생성자
    public ClubDto(Club club) {
        this.id = club.getId();
        this.clubName = club.getName();
        this.clubIntroduce = club.getIntroduce();
        this.clubImage = club.getImage();
        this.category = club.getCategory();
        this.region = club.getRegion();
        this.clubDay = club.getClubDay();
        this.likeCount = club.getLikeCount();
    }
}
