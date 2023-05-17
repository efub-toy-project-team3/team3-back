package com.efub.series.domain.content.domain;

import com.efub.series.global.common.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity//해당 클래스에 있는 내부변수에 모두 @Column을 내부적으로 포함 -> 옵셥없으면 생략 가능
@NoArgsConstructor(access = AccessLevel.PROTECTED) //기본 생성자의 접근 제어를 PROTECTED로 설정해놓게 되면 무분별한 객체 생성에 대해 한번 더 체크할 수 있는 수단
@Getter
public class Content extends BaseTimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "content_id", updatable = false)
	private Long contentId;

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

	@OneToMany(mappedBy = "content", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Page> pageList = new ArrayList<>();

	@OneToMany(mappedBy = "hashtag", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ContentHashtag> contentHashtags = new ArrayList<>();

	@Builder
	public Content(String type, String genre, String title, Long grade, Long comments, Boolean isComplete, String writer, String shortDescription, String longDescription, String freeType, Long episodeCount, String image, Long downloadCount) {
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

	public void updateHashtag(ContentHashtag contentHashtag){
		this.contentHashtags.add(contentHashtag);
		contentHashtag.setContent(this);
	}

}