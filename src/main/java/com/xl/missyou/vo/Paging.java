package com.xl.missyou.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class Paging<T> {
    private Long total;
    // 每页多少 size
    private Integer count;
    private Integer page;
    private Integer totalPage;
    private List<T> items;

    public Paging(Page<T> pageT){
        this.init(pageT);
        this.items = pageT.getContent();
    }

    public void init (Page<T> pageT){
        this.total = pageT.getTotalElements();
        this.count = pageT.getSize();
        this.totalPage = pageT.getTotalPages();
        this.page = pageT.getNumber();
    }
}
