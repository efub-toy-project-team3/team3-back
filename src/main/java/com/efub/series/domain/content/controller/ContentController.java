package com.efub.series.domain.content.controller;


import com.efub.series.domain.content.domain.Content;
import com.efub.series.domain.content.domain.ContentHashtag;
import com.efub.series.domain.content.domain.Hashtag;
import com.efub.series.domain.content.dto.*;
import com.efub.series.domain.content.repository.ContentRepository;
import com.efub.series.domain.content.service.ContentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/contents")
@RequiredArgsConstructor
public class ContentController {

	private final ContentRepository contentRepository;
	private final ContentService contentService;

	@GetMapping("/{contentId}/details")
	@ResponseStatus(value = HttpStatus.OK)
	public ContentDetailResDto getDetail(@PathVariable final Long contentId){
		Content content = contentService.get(contentId);
		//List<Content> otherWorkList = contentService.findAllByAuthor(content.getWriter()); //TODO : 작품 데이터가 5개 이상이면 다시 변경
		List<Content> otherWorkList = contentService.getOtherWorkList();
		List<Content> viewedWorkList = contentService.getViewedWorkList(); // TODO : 로그인 기능 추가 시 수정 필요
		return new ContentDetailResDto(content, otherWorkList, viewedWorkList);

	}

	@GetMapping("/{contentId}/hashtags")
	@ResponseStatus(value = HttpStatus.OK)
	public HashtagListResDto getHashtagList(@PathVariable final Long contentId){
		List<ContentHashtag> hashtags = contentService.getContentHashtags(contentId);
		return HashtagListResDto.of(hashtags);
	}

	@PostMapping("/{contentId}/hashtags")
	@ResponseStatus(value = HttpStatus.OK)
	public HashtagListResDto.HashtagResDto createHashtag(@PathVariable final Long contentId, @RequestBody final HashtagReqDto hashtagReqDto){
		Long contentHashtagId = contentService.createHashtag(contentId, hashtagReqDto);
		ContentHashtag hashtag = contentService.findByContentHashtagId(contentHashtagId);
		return HashtagListResDto.HashtagResDto.of(hashtag);
	}


	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)//TEST 용으로
	public ContentResDto createContent(@RequestBody final ContentReqDto contentReqDto)
	{
		Long contentId = contentService.create(contentReqDto);
		Content content = contentService.findById(contentId);
		return new ContentResDto(content);
	}

}
