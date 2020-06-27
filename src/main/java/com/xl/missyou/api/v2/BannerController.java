package com.xl.missyou.api.v2;

import com.xl.missyou.exception.http.ForbiddenException;
import com.xl.missyou.exception.http.NotFoundException;
import com.xl.missyou.sample.hero.Diana;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

//@Controller
//@ResponseBody
@RestController()
@RequestMapping("/banner/")
//@Lazy
public class BannerController {

    @Autowired
    private Diana diana;


    @GetMapping("/test")
//    @PostMapping("/test")
//    @RequestMapping(value = "test",method = {RequestMethod.GET,RequestMethod.POST})
//    @ResponseBody
    public String test() throws Exception {

        diana.q();
        throw new ForbiddenException(10001);
//        throw new Exception("dwewq");

//        return "0527_xl?12sd32ewewwew";
    }
}
