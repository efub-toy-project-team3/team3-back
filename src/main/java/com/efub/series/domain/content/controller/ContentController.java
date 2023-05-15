package com.efub.series.domain.content.controller;


import com.efub.series.domain.content.domain.Content;
import com.efub.series.domain.content.domain.ContentHashtag;
import com.efub.series.domain.content.domain.Hashtag;
import com.efub.series.domain.content.dto.ContentDetailResDto;
import com.efub.series.domain.content.dto.ContentReqDto;
import com.efub.series.domain.content.repository.ContentRepository;
import com.efub.series.domain.content.service.ContentService;
import com.efub.series.domain.content.dto.HashtagListResDto;
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
		List<Content> otherWorkList = contentService.findAllByAuthor(content.getWriter());
		List<Content> viewedWorkList = new ArrayList<>();
		return new ContentDetailResDto(content, otherWorkList, viewedWorkList);

	}

	@GetMapping("/{contentId}/hashtags")
	@ResponseStatus(value = HttpStatus.OK)
	public HashtagListResDto getHashtagList(@PathVariable final Long contentId){
		List<ContentHashtag> hashtags = contentService.getContentHashtags(contentId);
		return HashtagListResDto.of(hashtags);
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)//TEST 용으로
	public String createContent(@RequestBody final ContentReqDto contentReqDto)
	{
		contentService.create(contentReqDto);
		return "성공";
	}

}
