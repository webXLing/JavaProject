package com.xl.missyou.model;
//
import javax.persistence.*;
import java.util.List;

// orm 生成表
@Entity
//修改表名
//@Table(name = "banner1")
public class Banner {
    @Id
    // 自增 主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
//    设置长度
    @Column(length = 16)
    private String name;
//    不显示在表中
    @Transient
    private String description;
    private String img;
    private String title;

    // 默认懒加载 用到才会sql
    // 急加载 fetch = FetchType.EAGER
    //mappedBy BannerItem的导航属性的名字 banner
    @OneToMany(mappedBy = "banner",fetch = FetchType.EAGER)
    // 设置外键
//    @JoinColumn(name = "bannerId")
    private List<BannerItem> items;
}
