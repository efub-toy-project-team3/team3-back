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
	private Long grade;
	private Long comments;
	private Boolean isComplete;
	private String writer;

	private String shortDescription;
	private String longDescription;
	private String freeType;
	private Long episodeCount;
	private String image;
	private Long downloadCount;

	public ContentReqDto(String type, String genre, String title, Long grade, Long comments, Boolean isComplete, String writer, String shortDescription, String longDescription, String freeType, Long episodeCount, String image, Long downloadCount) {
		this.type = type;
		this.genre = genre;
		this.title = title;
		this.grade = grade;
		this.comments = comments;
		this.isComplete = isComplete;
		this.writer = writer;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
		this.freeType = freeType;
		this.episodeCount = episodeCount;
		this.image = image;
		this.downloadCount = downloadCount;
	}

	public Content toEntity()
	{
		return Content.builder()
				.title(title)
				.genre(genre)
				.writer(writer)
				.comments(comments)
				.downloadCount(downloadCount)
				.episodeCount(episodeCount)
				.freeType(freeType)
				.grade(grade)
				.image(image)
				.isComplete(isComplete)
				.longDescription(longDescription)
				.shortDescription(shortDescription)
				.type(type)
				.build();
	}

}
