package com.efub.series.domain.content.domain;

import com.efub.series.global.common.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity//해당 클래스에 있는 내부변수에 모두 @Column을 내부적으로 포함 -> 옵셥없으면 생략 가능
@NoArgsConstructor(access = AccessLevel.PROTECTED) //기본 생성자의 접근 제어를 PROTECTED로 설정해놓게 되면 무분별한 객체 생성에 대해 한번 더 체크할 수 있는 수단
@Getter
public class Page extends BaseTimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "page_id", updatable = false)
	private Long pageId;

	private String title;

	private Long episodeNumber;

	private Boolean isFree;

	private LocalDate date;
	private Float size;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "content_id", updatable = false)
	private Content content;


	@Builder
	public Page(Boolean isFree, LocalDate date, Float size) {
		this.isFree = isFree;
		this.date = date;
		this.size = size;
	}

	public void setContent(Content content) {
		if (this.content != null) { // 기존에 존재한다면
			this.content.getPageList().remove(this); // 관계를 끊는다.
		}
		this.content = content;
		if(!content.getPageList().contains(this)) {
			content.getPageList().add(this);
		}
	}
}
