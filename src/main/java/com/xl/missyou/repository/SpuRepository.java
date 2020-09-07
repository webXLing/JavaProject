package com.xl.missyou.repository;

import com.xl.missyou.model.Author;
import com.xl.missyou.model.Spu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpuRepository extends JpaRepository<Spu,Long> {
    Spu findOneById(Long id);

//    "select * from spu where category_id = cid"
    // 倒叙
    Page<Spu> findByCategoryIdOOrderByCreateTimeDesc(Long cid, Pageable pageable);

    Page<Spu> findByRootCategoryIdOrderByCreateTime(Long cid, Pageable pageable);

}
