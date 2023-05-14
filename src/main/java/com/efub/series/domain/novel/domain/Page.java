package com.efub.series.domain.novel.domain;

import com.efub.series.global.common.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor(access= AccessLevel.PROTECTED)
@Getter
public class Page extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="page_id", updatable=false)
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
}
