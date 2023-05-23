package com.efub.series.domain.content.dto;

import com.efub.series.domain.content.domain.Content;
import com.efub.series.domain.content.domain.ContentHashtag;
import com.efub.series.domain.content.domain.Page;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;
/*
  "genre": "로맨스",
  "title": "첫눈이 내리면",
  "rating": 4.5,
  "comment_count": 100,
  "completed": true,
  "author": "홍길동",
  "shortDescription": "첫 눈에 반한 인연의 이야기",
  "longDescription": "한 겨울, 첫눈이 내리면 마을에서는...",
  "totalEpisodes": 50,
  "imageUrl": "https://example.com/image.jpg",
  "downloadCount": 1000,
  "hashtags": ["로맨스", "겨울", "첫사랑"],
  	"episodes": [
    {
      "episode_number": 1,
      "title": "무한의 시작",
      "date": "2022-01-01",
      "free": true
    },
    {
      "episode_number": 2,
      "title": "끝나지 않은 여행",
      "date": "2022-01-08",
      "free": false
    },
    "otherWorks": [
    {
      "genre": "미스터리",
      "title": "연인이여, 돌아와줘",
      "downloadCount": 5000
    },
 */

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ContentDetailResDto {
	private ContentResDto contentDetail;
	private EpisodeListResDto episodes;
	private WorkListResDto otherWorks;
	private WorkListResDto viewedWorks;
	private HashtagListResDto hashtags;

	@Getter
	public static class ContentResDto {
		private String genre;
		private String title;
		private Long rating;
		private Long commentCount;
		private Boolean completed;
		private String author;
		private String shortDescription;
		private String longDescription;
		private Long totalEpisodes;
		private String imageUrl;
		private Long downloadCount;

		private String shortNotice;
		private String longNotice;
		public ContentResDto(Content content){
			genre = content.getGenre();
			title = content.getTitle();
			rating = content.getGrade();
			commentCount = content.getComments();
			completed = content.getIsComplete();
			author = content.getWriter();
			shortDescription = content.getShortDescription();
			longDescription = content.getLongDescription();
			totalEpisodes = content.getEpisodeCount();
			imageUrl = content.getImage();
			downloadCount = content.getDownloadCount();
			shortNotice = content.getNotices().get(content.getNotices().size() -1).getTitle();
			longNotice = content.getNotices().get(content.getNotices().size() -1).getNoticeBody();
		}
	}



	public ContentDetailResDto(Content content, List<Content> otherWorkList, List<Content> viewedWorkList, List<ContentHashtag> hashtagList){
		contentDetail = new ContentResDto(content);
		episodes = EpisodeListResDto.of(content.getPageList());
		otherWorks = WorkListResDto.of(otherWorkList);
		viewedWorks = WorkListResDto.of(viewedWorkList);
		hashtags = HashtagListResDto.of(hashtagList);

	}



}
