package com.efub.series.domain.content.dto;

import com.efub.series.domain.content.domain.Hashtag;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class HashtagReqDto {
	private String tag;

	public Hashtag toEntity(){
		return new Hashtag(tag);
	}

}
