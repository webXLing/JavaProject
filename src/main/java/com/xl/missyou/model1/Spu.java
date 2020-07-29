package com.xl.missyou.model1;

import javax.persistence.Entity;
import javax.persistence.Id;

//@Entity
public class Spu {
    @Id
    private Long id;
    private String title;
    private String subTitle;

//    @ManyToMany
//    private List<Theme> themeList;
}
