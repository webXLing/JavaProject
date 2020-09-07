package com.xl.missyou.vo;
// 后端传递给前端的对象
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SpuVO {
    private Long id;
    private String title;
    private String subtitle;
    private String img;
    private String price;
    private String discountPrice;
    private String description;
    private String tags;
    private Integer sketchSpecId;
    private String forThemeImg;

}
