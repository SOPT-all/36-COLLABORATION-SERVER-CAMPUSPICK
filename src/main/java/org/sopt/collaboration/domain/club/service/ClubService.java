package org.sopt.collaboration.domain.club.service;

import lombok.RequiredArgsConstructor;
import org.sopt.collaboration.domain.club.dto.ClubDto;
import org.sopt.collaboration.domain.club.repository.ClubRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ClubService {
    private final ClubRepository clubRepository;

    public List<ClubDto> getClubsByLikesDesc(){
        return clubRepository.findTop3ByOrderByLikeCountDesc()
                .stream()
                .map(ClubDto::new)
                .toList();
    }
}