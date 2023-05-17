package com.efub.series.domain.content.service;

import com.efub.series.domain.content.domain.Hashtag;
import com.efub.series.domain.content.repository.HashtagRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class HashtagService {
	private final HashtagRepository hashtagRepository;

	public Hashtag saveHashtag(Hashtag hashtag){
		return hashtagRepository.save(hashtag);
	}


	@Transactional(readOnly = true)
	public boolean existsByTag(String tag){
		return hashtagRepository.existsByTag(tag);
	}

	@Transactional(readOnly = true)
	public Hashtag findByTag(String tag){
		return hashtagRepository.findHashtagByTag(tag)
				.orElseThrow(EntityNotFoundException::new);

	}

}
