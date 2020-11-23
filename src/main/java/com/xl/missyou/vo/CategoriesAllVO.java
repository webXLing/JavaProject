package com.xl.missyou.vo;

import com.xl.missyou.model.Category;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@Setter
public class CategoriesAllVO {
    private List<CategoryPureVO> roots;
    private List<CategoryPureVO> subs;

    /**
     * CategoryPureVO 是为了 不需要的字段不返回前端  以及 由于category 多对多的关系 导致了 可能会在成序列化的循环
     * @param map
     */
    public CategoriesAllVO(Map<Integer, List<Category>> map) {
        this.roots = map.get(1).stream()
                .map(CategoryPureVO::new)
                .collect(Collectors.toList());
        this.subs = map.get(2).stream()
                .map(CategoryPureVO::new)
                .collect(Collectors.toList());

    }
}
