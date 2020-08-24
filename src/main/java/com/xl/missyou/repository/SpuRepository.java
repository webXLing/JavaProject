package com.xl.missyou.repository;

import com.xl.missyou.model.Author;
import com.xl.missyou.model.Spu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpuRepository extends JpaRepository<Spu,Long> {
    Spu findOneById(Long id);
}
