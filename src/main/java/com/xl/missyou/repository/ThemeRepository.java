package com.xl.missyou.repository;

import com.xl.missyou.model.Theme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ThemeRepository extends JpaRepository<Theme,Long> {

    @Query(value="select a.name from Theme a where a.name=?1 or a.name = ?2 ")
    List<Theme> getThemesByNames(String name1,String name2);

    @Query(value = "select theme from Theme theme where theme.name in (:names)")
    List<Theme> getByArr(@Param("names") List<String> myNames);

    Theme getById(Long id);

    List<Theme> findAll();

    Optional<Theme> getByName(String name);

}
