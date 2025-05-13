package org.sopt.collaboration.domain.club.controller;


import lombok.RequiredArgsConstructor;
import org.sopt.collaboration.domain.club.dto.ClubDto;
import org.sopt.collaboration.domain.club.service.ClubService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ClubController {
    private final ClubService clubService;

    @GetMapping("/club")
    public ResponseEntity<List<ClubDto>> getClubsByLikes(){
        List<ClubDto> club = clubService.getClubsByLikesDesc();
        return ResponseEntity.ok(club);
    }
}
