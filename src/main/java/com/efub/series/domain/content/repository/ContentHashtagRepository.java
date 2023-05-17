package com.efub.series.domain.content.repository;

import com.efub.series.domain.content.domain.Content;
import com.efub.series.domain.content.domain.ContentHashtag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContentHashtagRepository extends JpaRepository<ContentHashtag, Long> {
	List<ContentHashtag> findByContent(Content content);
}
