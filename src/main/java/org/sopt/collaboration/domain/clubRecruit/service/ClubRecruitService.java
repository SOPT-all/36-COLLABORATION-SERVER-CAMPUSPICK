package org.sopt.collaboration.domain.clubRecruit.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sopt.collaboration.domain.clubRecruit.dto.ClubRecruitDto;
import org.sopt.collaboration.domain.clubRecruit.repository.ClubRecruitRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ClubRecruitService {
    private final ClubRecruitRepository clubRecruitRepository;

    public List<ClubRecruitDto> getClubRecruitByViewCount() {
        return clubRecruitRepository.findTop5ByOrderByViewCountDesc()
                .stream()
                .map(ClubRecruitDto::new)
                .toList();
    }
}
