package com.xl.missyou.model;

import com.xl.missyou.util.ListAndJson;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Data
public class Sku  extends BaseEntity{
    @Id
    private Long id;
    private BigDecimal price;
    private BigDecimal discountPrice;
    private Boolean online;
    private String img;
    private String title;
    private Long spuId;

    // 字符串
    // "specs": "[{\"key\": \"颜色\", \"value\": \"青蓝色\", \"key_id\": 1, \"value_id\": 1}, {\"key\": \"尺寸\", \"value\": \"7英寸\", \"key_id\": 2, \"value_id\": 5}]",
//    private String specs;
    //  将其序列化为数组给前端

    /**
     * 方法一 手写 setter getter
     * @return
     */
//    public List<Specs> getSpecs(){
//        String specs = this.specs;
////        Jackson 去转成数组 specs
//        ArrayList arrayList = new ArrayList();
//        return arrayList;
//    }
//
//    public void setSpecs (List<Specs> specs){
//        //Jackson 数组转成字符串 specs
//        this.specs = "[]";
//    }

    /**
     * 方法二 分装
     */
    @Convert(converter = ListAndJson.class)
    private List<Object> specs;

    private String code;

    private Long stock;
    private Long categoryId;
    private Long rootCategoryId;

}
