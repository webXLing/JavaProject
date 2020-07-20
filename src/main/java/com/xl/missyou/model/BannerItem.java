package com.xl.missyou.model;
//
import javax.persistence.*;

// orm 生成表
@Entity
//修改表名
public class BannerItem {
    @Id
    // 自增 主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String img;
    // 配合type
    private String keyword;
    // 类型
    private Short type;
    // 名称
    private String name;
    private long bannerId;
}
