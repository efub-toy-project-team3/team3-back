package com.efub.series.domain.content.dto;

import com.efub.series.domain.content.domain.ContentHashtag;
import com.efub.series.domain.content.domain.Hashtag;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class HashtagListResDto {

	private List<HashtagResDto> hashtagList;

	@Getter
	public static class HashtagResDto{
		private Long hashtagId;
		private String tag;

		public HashtagResDto(ContentHashtag hashtag){
			this.hashtagId = hashtag.getHashtag().getHashtagId();
			this.tag = hashtag.getHashtag().getTag();
		}
		public static HashtagResDto of(ContentHashtag hashtag){
			return new HashtagResDto(hashtag);
		}


	}
	public static HashtagListResDto of(List<ContentHashtag> hashtagList) {
		return HashtagListResDto.builder()
				.hashtagList(hashtagList.stream().map(HashtagResDto::of).collect(Collectors.toList()))
				.build();
	}
}
