package com.efub.series.domain.content.domain;

import com.efub.series.global.common.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity//해당 클래스에 있는 내부변수에 모두 @Column을 내부적으로 포함 -> 옵셥없으면 생략 가능
@NoArgsConstructor(access = AccessLevel.PROTECTED) //기본 생성자의 접근 제어를 PROTECTED로 설정해놓게 되면 무분별한 객체 생성에 대해 한번 더 체크할 수 있는 수단
@Getter
public class Hashtag extends BaseTimeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "hashtag_id", updatable = false)
	private Long hashtagId;

	private String tag;

	@OneToMany(mappedBy = "hashtag", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ContentHashtag> contentHashtags = new ArrayList<>();

	public Hashtag(String tag) {
		this.tag = tag;
	}
}
