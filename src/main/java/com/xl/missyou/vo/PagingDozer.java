package com.xl.missyou.vo;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

// T 数据库 查询的对象的 model
// K 要转换的 对象class
// 构建一个 可以编辑 item的 paging
public class PagingDozer<T,K> extends Paging {
    public PagingDozer(Page<T> pageT ,Class<K> kClass){
        this.init(pageT);
        // 重新 赋值items
        List<T> tList = pageT.getContent();
        List<K> voList = new ArrayList<>();
        // 对象和对象 之间转换
        Mapper mapper = DozerBeanMapperBuilder.buildDefault();
        tList.forEach(t -> {
            K vo = mapper.map(t, kClass);
            voList.add(vo);
        });
        this.setItems(voList);
    }
}
