package com.xl.missyou.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
// 这不是一个实体 而是实体的基类
//这样 createTime 就能返回到前端
@MappedSuperclass
public abstract class BaseEntity {
    private Date createTime;
    private Date updateTime;
    private Date deleteTime;
}
