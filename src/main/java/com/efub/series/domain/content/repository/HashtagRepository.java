package com.efub.series.domain.content.repository;

import com.efub.series.domain.content.domain.Hashtag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HashtagRepository extends JpaRepository<Hashtag, Long> {

	Optional<Hashtag> findHashtagByTag(String tag);
	Boolean existsByTag(String tag);
}
