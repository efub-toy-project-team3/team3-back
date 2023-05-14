package com.efub.series.domain.novel.service;

import com.efub.series.domain.novel.domain.Content;
import com.efub.series.domain.novel.repository.NovelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class NovelService {
    private final NovelRepository novelRepository;

    @Transactional(readOnly = true)
    public List<Content> findTop5ByType(String type){
        return novelRepository.findTop5ByType(type);
    }

    @Transactional(readOnly = true)
    public List<Content> findTop5ByTypeAndFreeType(String type, String freeType){
        return novelRepository.findTop5ByTypeAndFreeType(type, freeType);
    }
}
