package com.xl.missyou.api.v1;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import com.xl.missyou.exception.http.NotFoundException;
import com.xl.missyou.model.Theme;
import com.xl.missyou.service.ThemeService;
import com.xl.missyou.vo.ThemePureVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RequestMapping("/theme/")
@RestController
public class ThemeController {

    @Autowired
    private ThemeService themeService;


    /**
     * 通过输入一段拼接的字符串  查询主题
     * @param names
     * @return
     */
    @GetMapping("/by/names")
    public List<ThemePureVO> findByArr(@RequestParam("names") String names){

        List<String> strings = Arrays.asList(names.split(","));
        List<Theme> themes = themeService.findByArr(strings);
        //        去除spu 的相关数据
        List<ThemePureVO> themePureVOList = new ArrayList<>();
        themes.forEach(item->{
//            对象转换的组件。 DozerBeanMapperBuilder
            Mapper mapper = DozerBeanMapperBuilder.buildDefault();
            ThemePureVO map = mapper.map(item, ThemePureVO.class);
            themePureVOList.add(map);
        });
        return themePureVOList;
    }

    /**
     * 查询某个tehme 带有spu
     * @param name
     * @return
     */
    @GetMapping("/name/{name}/with_spu")
    public Theme getWithSpu(@PathVariable("name") String name){
     Optional<Theme> theme =  themeService.getByName(name);
     return theme.orElseThrow(()-> new NotFoundException(300006));
    }

    /**
     * 查询一组theme 主题
     * @return
     */
    @GetMapping("by/name1name2")
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
