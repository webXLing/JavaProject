package com.xl.missyou.api.v1;

import com.xl.missyou.model.Theme;
import com.xl.missyou.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/theme/")
@RestController
public class ThemeController {

    @Autowired
    private ThemeService themeService;

    @GetMapping("by/names")
    public List<Theme> getByName(){
//        System.out.println(theme2);
//        List<Theme> themesByName = themeService.getThemesByName(theme1, theme2);

        List<Theme> all = themeService.findAll();
        System.out.println("theme->getByName");
        System.out.println(all);
        String a = "SELECT * FROM theme a WHERE a.name='name1' or a.name = name2";
        return all;
    }

    @GetMapping("by/id")
    public Theme getById(@RequestParam Long id){
        Theme byId = themeService.getById(id);
        System.out.println(byId);
        return byId;
    }
}
