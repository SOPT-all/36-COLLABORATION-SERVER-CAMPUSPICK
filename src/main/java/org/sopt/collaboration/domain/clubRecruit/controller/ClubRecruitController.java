package org.sopt.collaboration.domain.clubRecruit.controller;

import lombok.RequiredArgsConstructor;
import org.sopt.collaboration.domain.clubRecruit.dto.ClubRecruitDto;
import org.sopt.collaboration.domain.clubRecruit.service.ClubRecruitService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ClubRecruitController {
    private final ClubRecruitService clubRecruitService;

    @GetMapping("/clubs/popular")
    public ResponseEntity<List<ClubRecruitDto>> getClubRecruitByViewCount() {
        List<ClubRecruitDto> clubRecruit = clubRecruitService.getClubRecruitByViewCount();
        return ResponseEntity.ok(clubRecruit);
    }
}
