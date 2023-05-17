package com.efub.series.domain.content.dto;

import com.efub.series.domain.content.domain.Content;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ContentResDto {
	private Long contentId;
	private String title;
	private String image;
	private String writer;

	@Builder
	public ContentResDto(Content content) {
		this.contentId = content.getContentId();
		this.title = content.getTitle();
		this.image = content.getImage();
		this.writer = content.getWriter();
	}
}
