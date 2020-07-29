package com.xl.missyou.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public abstract class BaseEntity {
    private Date createTime;
    private Date updateTime;
    private Date deleteTime;
}
