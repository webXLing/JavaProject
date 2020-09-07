package com.xl.missyou.util;

import com.xl.missyou.bo.PageCounter;

public class CommonUtil {
   public static PageCounter ConvertToPageParams(Integer start,Integer count){
        Integer pageNum = start/count;
        PageCounter build = PageCounter.builder()
                .page(pageNum)
                .size(count)
                .build();

        return build;
    }
}
