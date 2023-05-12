package com.efub.series.domain.content.dto;

import com.efub.series.domain.content.domain.Content;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ContentReqDto {
	private String type;
	private String genre;
	private String title;
	private String writer;

	@Builder
	public ContentReqDto(String type, String genre, String title, String writer) {
		this.type = type;
		this.genre = genre;
		this.title = title;
		this.writer = writer;
	}

	public Content toEntity()
	{
		return Content.builder()
				.type(type)
				.writer(writer)
				.genre(genre)
				.title(title)
						.build();
	}

}
