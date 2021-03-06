package com.xl.missyou.model1;

import javax.persistence.*;
import java.util.List;

//@Entity
public class Theme {
    @Id
    private Long id;
    private String title;
    private String name;

    @ManyToMany
    // 中间表设置
    @JoinTable(name = "theme_spu",joinColumns = @JoinColumn(name="theme_id"),inverseJoinColumns = @JoinColumn(name = "spu_id"))
    private List<Spu> spuList;

}
