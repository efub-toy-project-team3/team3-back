package com.efub.series.domain.comic.service;

import com.efub.series.domain.comic.domain.Content;
import com.efub.series.domain.comic.repository.ComicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ComicService {
    private final ComicRepository comicRepository;

    @Transactional(readOnly = true)
    public List<Content> findTop5ByType(String type){

        return comicRepository.findTop5ByType(type);
    }

    @Transactional(readOnly = true)
    public List<Content> findTop5ByTypeAndFreeType(String type, String freeType){
        return comicRepository.findTop5ByTypeAndFreeType(type, freeType);
    }
}
