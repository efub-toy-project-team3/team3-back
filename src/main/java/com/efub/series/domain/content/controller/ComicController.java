package com.efub.series.domain.content.controller;

import com.efub.series.domain.content.domain.Content;
import com.efub.series.domain.content.dto.ComicListResDto;
import com.efub.series.domain.content.service.ContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comics")
@RequiredArgsConstructor
public class ComicController {

    private final ContentService contentService;

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public ComicListResDto getContentList(){
        List<Content> comicList = contentService.findTop5ByType("comic");
        return ComicListResDto.of(comicList);
    }

    @GetMapping("/freeList")
    @ResponseStatus(value = HttpStatus.OK)
    public ComicListResDto getComicFreeList(@RequestParam String freeType){
        List<Content> comicFreeList = contentService.findTop5ByTypeAndFreeType("comic", freeType);
        return ComicListResDto.of(comicFreeList);
    }
}
