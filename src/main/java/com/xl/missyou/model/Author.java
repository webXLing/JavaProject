package com.xl.missyou.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
public class Author {
    private String authorName;
    @Id
    private Long id;

    //单向 一对多
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "myAuthorId")
    private List<Article> articleList;

//    @OneToMany(mappedBy = "author",fetch = FetchType.EAGER)
//    private List<Article> articleList;
}
