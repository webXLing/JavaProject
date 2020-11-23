package com.xl.missyou.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
public class Theme  extends BaseEntity{
    @Id
//    private Long id;
//    private String title;
//    private String description;
//    private String name;
//    private String tplName;
//    private String entranceImg;
//    private String extend;
//    private String internalTopImg;
//    private String titleImg;
//    private Short online;
    private Long id;
    private String title;
    private String description;
    private String name;
    private String extend;
    private String entranceImg;
    private String internalTopImg;
    private Boolean online;
    private String titleImg;
    private String tplName;

    /**
     * 多对多  theme 是关系的维护端
    //1、关系维护端，负责多对多关系的绑定和解除
    //2、@JoinTable注解的name属性指定关联表的名字(中间表)，joinColumns指定外键的名字 theme_id，关联到关系维护端(Theme)
    //3、inverseJoinColumns指定外键的名字，要关联的关系被维护端(Spu)
    //4、其实可以不使用@JoinTable注解，默认生成的关联表名称为主表表名+下划线+从表表名，
    //即表名为user_authority
    //关联到主表的外键名：主表名+下划线+主表中的主键列名,即user_id
    //关联到从表的外键名：主表中用于关联的属性名+下划线+从表的主键列名,即authority_id
    //主表就是关系维护端对应的表，从表就是关系被维护端对应的表
     */
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="theme_spu",joinColumns = @JoinColumn(name = "theme_id")
            ,inverseJoinColumns=@JoinColumn(name="spu_id"))
    private List<Spu> spuList;
}
