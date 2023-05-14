package com.efub.series.domain.content.dto;

import com.efub.series.domain.content.domain.Content;
import com.efub.series.domain.content.domain.Page;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class WorkListResDto {
	List<WorkResDto> workList;

	@Getter
	public static class WorkResDto{
		private String genre;
		private String title;
		private Long downloadCount;
		public WorkResDto(Content content) {
			this.genre = content.getGenre();
			this.title = content.getTitle();
			this.downloadCount = content.getDownloadCount();
		}

		public static WorkResDto of(Content content)
		{
			return new WorkResDto(content);
		}


	}
	public static WorkListResDto of(List<Content> contentList) {
		return WorkListResDto.builder()
				.workList(contentList.stream().map(WorkListResDto.WorkResDto::of).collect(Collectors.toList()))
				.build();
	}





}
