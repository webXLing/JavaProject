package com.xl.missyou.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Data
//@Table(name = "spu_detail_img", schema = "sleeve", catalog = "")
public class SpuDetailImg extends BaseEntity{
    @Id
    private Long id;
    private String img;
    private Long spuId;
    private Long index;


}
