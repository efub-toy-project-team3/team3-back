package com.efub.series.domain.content.service;

import com.efub.series.domain.content.domain.Content;
import com.efub.series.domain.content.repository.ContentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ContentService {
    private final ContentRepository contentRepository;

    @Transactional(readOnly = true)
    public List<Content> findTop5ByType(String type){

        return contentRepository.findTop5ByType(type);
    }

    @Transactional(readOnly = true)
    public List<Content> findTop5ByTypeAndFreeType(String type, String freeType){
        return contentRepository.findTop5ByTypeAndFreeType(type, freeType);
    }
}
