package com.xl.missyou.service;

import com.xl.missyou.model.Theme;

import java.util.List;
import java.util.Optional;

public interface ThemeService {
    Optional<Theme> getByName(String name);
    List<Theme> getThemesByNames(String name1, String name2);
    List<Theme> findByArr(List<String> name);
    Theme getById(Long id);
    List<Theme> findAll();
}
