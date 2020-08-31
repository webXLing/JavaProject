package com.xl.missyou.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Data
public class SpuImg extends BaseEntity{
    @Id
    private Long id;
    private String img;
    private Long spuId;


}
