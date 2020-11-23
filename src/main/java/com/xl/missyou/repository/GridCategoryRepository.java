package com.xl.missyou.repository;

import com.xl.missyou.model.Category;
import com.xl.missyou.model.GridCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GridCategoryRepository extends JpaRepository<GridCategory,Long> {
}
