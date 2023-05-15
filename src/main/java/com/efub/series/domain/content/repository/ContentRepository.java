package com.efub.series.domain.content.repository;

import com.efub.series.domain.content.domain.Content;
import com.efub.series.domain.content.domain.Hashtag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContentRepository extends JpaRepository<Content, Long> {
	List<Content> findAllByWriter(String writer);


}
