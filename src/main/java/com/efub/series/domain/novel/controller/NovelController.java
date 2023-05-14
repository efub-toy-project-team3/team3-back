package com.efub.series.domain.novel.controller;

import com.efub.series.domain.novel.domain.Content;
import com.efub.series.domain.novel.dto.NovelListResDto;
import com.efub.series.domain.novel.service.NovelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/novels")
@RequiredArgsConstructor
public class NovelController {

    private final NovelService novelService;

    @GetMapping()
    @ResponseStatus(value = HttpStatus.OK)
    public NovelListResDto  getNovelList(){
        List<Content> novelList = novelService.findTop5ByType("novel");
        return NovelListResDto.of(novelList);
    }
}
