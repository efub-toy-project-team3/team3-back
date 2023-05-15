package com.efub.series.domain.content.controller;

import com.efub.series.domain.content.domain.Content;
import com.efub.series.domain.content.dto.NovelListResDto;
import com.efub.series.domain.content.service.ContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/novels")
@RequiredArgsConstructor
public class NovelController {

    private final ContentService contentService;

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public NovelListResDto  getNovelList(){
        List<Content> novelList = contentService.findTop5ByType("novel");
        return NovelListResDto.of(novelList);
    }

    @GetMapping("/freeList")
    @ResponseStatus(value = HttpStatus.OK)
    public NovelListResDto getNovelFreeList(@RequestParam String freeType){
        List<Content> novelFreeList = contentService.findTop5ByTypeAndFreeType("novel", freeType);
        return NovelListResDto.of(novelFreeList);
    }
}
