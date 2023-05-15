package com.efub.series.domain.content.dto;

import com.efub.series.domain.content.domain.Page;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class EpisodeListResDto {
	List<EpisodeResDto> episodeList;
	@Getter
	public static class EpisodeResDto{
		private Long pageId;
		private Long episodeNumber;
		private String title;
		private LocalDate date;
		private Boolean isFree;

		public EpisodeResDto(Page page) {
			this.pageId = page.getPageId();
			this.episodeNumber = page.getEpisodeNumber();
			this.title = page.getTitle();
			this.date = page.getDate();
			this.isFree = page.getIsFree();
		}

		public static EpisodeResDto of(Page page)
		{
			return new EpisodeResDto(page);
		}


	}
	public static EpisodeListResDto of(List<Page> pageList) {
		return EpisodeListResDto.builder()
				.episodeList(pageList.stream().map(EpisodeResDto::of).collect(Collectors.toList()))
				.build();
	}
}
