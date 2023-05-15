package com.efub.series.domain.content.dto;

import com.efub.series.domain.content.domain.Content;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ComicListResDto {
    List<ComicResDto> comics;

    @Getter
    public static class ComicResDto{
        private Long contentId;
        private String image;

        public ComicResDto(Content content){
            this.contentId= content.getContentId();
            this.image= content.getImage();
        }

        public static ComicResDto of(Content content){
            return new ComicResDto(content);
        }
    }

    public static ComicListResDto of(List<Content> contentList){
        return ComicListResDto.builder()
                .comics(contentList.stream().map(ComicListResDto.ComicResDto::of).collect(Collectors.toList()))
                .build();
    }
}