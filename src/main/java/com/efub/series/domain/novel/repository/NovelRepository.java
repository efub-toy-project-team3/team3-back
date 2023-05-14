package com.efub.series.domain.novel.repository;

import com.efub.series.domain.novel.domain.Content;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NovelRepository extends JpaRepository<Content, Long> {
    List<Content> findTop5ByType(String type);
    List<Content> findTop5ByTypeAndFreeType(String type, String freeType);
}
