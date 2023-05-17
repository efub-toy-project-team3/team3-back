package com.efub.series.domain.content.service;

import com.efub.series.domain.content.domain.Content;
import com.efub.series.domain.content.domain.ContentHashtag;
import com.efub.series.domain.content.domain.Hashtag;
import com.efub.series.domain.content.dto.ContentReqDto;
import com.efub.series.domain.content.dto.HashtagReqDto;
import com.efub.series.domain.content.repository.ContentHashtagRepository;
import com.efub.series.domain.content.repository.ContentRepository;
import com.zaxxer.hikari.metrics.dropwizard.CodahaleMetricsTrackerFactory;
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
  private final ContentHashtagRepository contentHashtagRepository;
  private final HashtagService hashtagService;

  @Transactional(readOnly = true)
  public List<Content> findTop5ByType(String type){
      return contentRepository.findTop5ByType(type);
  }

  @Transactional(readOnly = true)
  public List<Content> findTop5ByTypeAndFreeType(String type, String freeType){
      return contentRepository.findTop5ByTypeAndFreeType(type, freeType);
  }

	public Long create(ContentReqDto contentReqDto){
		Content content = contentRepository.save(contentReqDto.toEntity());
		return content.getContentId();
	}


	public Content get(Long contentId){
		Content content = findById(contentId);
		return content;
	}

	public Long createHashtag(Long contentId, HashtagReqDto hashtagReqDto)
	{
		Hashtag hashtag;
		Content content = findById(contentId);
		//TODO: 이미 해시태그 설정이 되어있는지 조건 필요
		if(hashtagService.existsByTag(hashtagReqDto.getTag())){
			hashtag = hashtagService.findByTag(hashtagReqDto.getTag());
		}
		else{
			hashtag = hashtagReqDto.toEntity();
			hashtagService.saveHashtag(hashtag);
		}
		ContentHashtag contentHashtag = saveContentHashtag(content, hashtag);
		content.updateHashtag(contentHashtag);

		return contentHashtag.getContentHashtagId();
	}

	public ContentHashtag saveContentHashtag(Content content, Hashtag hashtag){
		ContentHashtag contentHashtag = ContentHashtag.builder()
				.content(content)
				.hashtag(hashtag)
				.build();
	  	return contentHashtagRepository.save(contentHashtag);
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
		return contentHashtagRepository.findByContent(content);

	}

	@Transactional(readOnly = true)
	public ContentHashtag findByContentHashtagId(Long contentHashtagId){
	  return contentHashtagRepository.findById(contentHashtagId)
			  .orElseThrow(EntityNotFoundException::new);
	}


}
