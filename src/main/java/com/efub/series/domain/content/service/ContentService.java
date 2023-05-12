package com.efub.series.domain.content.service;

import com.efub.series.domain.content.domain.Content;
import com.efub.series.domain.content.dto.ContentReqDto;
import com.efub.series.domain.content.repository.ContentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class ContentService {
	private final ContentRepository contentRepository;

	public void create(ContentReqDto contentReqDto){
		contentRepository.save(contentReqDto.toEntity());
	}

	@Transactional(readOnly = true)
	public Content findById(Long contentId){
		return contentRepository.findById(contentId)
				.orElseThrow(EntityNotFoundException::new);
	}

	@Transactional(readOnly = true)
	public List<Content> findAllByAuthor(String author){
		return contentRepository.findAllByAuthor(author);
	}
}
