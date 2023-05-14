package com.efub.series.domain.comic.controller;

import com.efub.series.domain.comic.domain.Content;
import com.efub.series.domain.comic.dto.ComicListResDto;
import com.efub.series.domain.comic.service.ComicService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comics")
@RequiredArgsConstructor
public class ComicController {

    private final ComicService comicService;

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public ComicListResDto  getComicList(){
        List<Content> comicList = comicService.findTop5ByType("comic");
        return ComicListResDto.of(comicList);
    }

    @GetMapping("/freeList")
    @ResponseStatus(value = HttpStatus.OK)
    public ComicListResDto getComicFreeList(@RequestParam String freeType){
        List<Content> comicFreeList = comicService.findTop5ByTypeAndFreeType("comic", freeType);
        return ComicListResDto.of(comicFreeList);
    }
}
