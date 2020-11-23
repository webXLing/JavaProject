package com.xl.missyou.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Setter
@Getter
public class GridCategory extends BaseEntity{
    @Id
    private Long id;
    private String name;
    private String img;
    private String title;
    private Long categoryId;
    private Long rootCategoryId;
}
