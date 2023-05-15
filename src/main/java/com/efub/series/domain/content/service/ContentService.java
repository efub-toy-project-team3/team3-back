package com.efub.series.domain.content.service;

import com.efub.series.domain.content.domain.Content;
import com.efub.series.domain.content.domain.ContentHashtag;
import com.efub.series.domain.content.domain.Hashtag;
import com.efub.series.domain.content.dto.ContentReqDto;
import com.efub.series.domain.content.repository.ContentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Slf4j
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

	public void create(ContentReqDto contentReqDto){
		contentRepository.save(contentReqDto.toEntity());
	}

	public Content get(Long contentId){
		Content content = findById(contentId);
		return content;
	}

	@Transactional(readOnly = true)
	public Content findById(Long contentId){
		return contentRepository.findById(contentId)
				.orElseThrow(EntityNotFoundException::new);
	}

	@Transactional(readOnly = true)
	public List<Content> findAllByAuthor(String author){
		return contentRepository.findAllByWriter(author);
	}

	@Transactional(readOnly = true)
	public List<ContentHashtag> getContentHashtags(Long contentId) {
		Content content = findById(contentId);
		return content.getContentHashtags();
	}
}
