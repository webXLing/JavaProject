package com.xl.missyou.service;

import com.xl.missyou.model.Theme;
import com.xl.missyou.repository.ThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThemeServiceImpl implements ThemeService{
    @Autowired
    private ThemeRepository themeRepository;
    @Override
    public List<Theme> getThemesByName(String name1, String name2) {
//        return themeRepository.getThemesByName(name1,name2);
        return themeRepository.getThemesByName(name1,name2);
    }

    @Override
    public Theme getById(Long id) {
        return themeRepository.getById(id);
    }

    @Override
    public List<Theme> findAll() {
        return themeRepository.findAll();
    }


}
