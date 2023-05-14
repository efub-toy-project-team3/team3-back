package com.efub.series.domain.hashtag.domain;

import com.efub.series.global.common.BaseTimeEntity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Hashtag extends BaseTimeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "hashtag_id", updatable = false)
	private Long hashtagId;

	private String tag;

	public Hashtag(String tag) {
		this.tag = tag;
	}
}
