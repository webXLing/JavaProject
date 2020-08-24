package com.xl.missyou.service;

import com.xl.missyou.model.Theme;

import java.util.List;

public interface ThemeService {
    List<Theme> getThemesByName(String name1, String name2);
    Theme getById(Long id);
    List<Theme> findAll();
}
