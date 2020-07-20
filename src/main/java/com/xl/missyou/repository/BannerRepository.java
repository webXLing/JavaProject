package com.xl.missyou.repository;

import com.xl.missyou.model.Banner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// 第一个参数为实体名 第二个为id 类型
@Repository
public interface BannerRepository extends JpaRepository<Banner,Long> {

  Banner findOneById(Long id);

  Banner findOneByName(String name);

}
