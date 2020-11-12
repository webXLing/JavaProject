package com.xl.missyou.repository;

import com.xl.missyou.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// 第一个参数为实体名 第二个为id 类型
//@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

//  查询所有 是否是 isRoot 的category 通过index 正序
  List<Category> findAllByIsRootOrderByIndexAsc(Boolean isRoot);
}
