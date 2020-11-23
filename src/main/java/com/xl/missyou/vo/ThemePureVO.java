/**
 * @作者 7七月
 * @微信公号 林间有风
 * @开源项目 $ http://7yue.pro
 * @免费专栏 $ http://course.7yue.pro
 * @我的课程 $ http://imooc.com/t/4294850
 * @创建时间 2020-03-10 16:28
 * CategoryPureVO 的目的是减少返回给前端的字段 不太用jsonignore 更加的灵活
 */
package com.xl.missyou.vo;

import com.xl.missyou.model.Category;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
public class ThemePureVO {
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
}
