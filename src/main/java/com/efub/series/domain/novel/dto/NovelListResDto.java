package com.efub.series.domain.novel.dto;

import com.efub.series.domain.novel.domain.Content;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class NovelListResDto {
    List<NovelResDto> novels;

    @Getter
    public static class NovelResDto{
        private Long contentId;
        private String image;

        public NovelResDto(Content content){
            this.contentId= content.getContentId();
            this.image= content.getImage();
        }

        public static NovelResDto of(Content content){
            return new NovelResDto(content);
        }
    }

    public static NovelListResDto of(List<Content> contentList){
        return NovelListResDto.builder()
                .novels(contentList.stream().map(NovelListResDto.NovelResDto::of).collect(Collectors.toList()))
                .build();
    }
}
