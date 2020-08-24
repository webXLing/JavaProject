package com.xl.missyou.repository;

import com.xl.missyou.model.Theme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ThemeRepository extends JpaRepository<Theme,Long> {

    @Query(value="select a.name from Theme a where a.name=?1 or a.name = ?2 ")
    List<Theme> getThemesByName(String name1,String name2);

    Theme getById(Long id);

    List<Theme> findAll();
}
