package com.xl.missyou.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
public class Article {
    private String title;
    @Id
    private Long id;

//    @ManyToOne
//    @JoinColumn(insertable = false, updatable = false, name = "myAuthorId")
    private String author;

//    //单向 一对多
    private Long myAuthorId;
}
