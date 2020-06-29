package com.xl.missyou.api.v1;

import com.xl.missyou.dto.PersionDTO;
import com.xl.missyou.exception.http.ForbiddenException;
import com.xl.missyou.exception.http.NotFoundException;
import com.xl.missyou.sample.hero.Diana;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

//@Controller
//@ResponseBody
@RestController()
@RequestMapping("/banner/")
//@Lazy
@Validated
public class BannerController {

    @Autowired
    private Diana diana;


    @GetMapping("/test/{id1}")
//    @PostMapping("/test")
//    @RequestMapping(value = "test",method = {RequestMethod.GET,RequestMethod.POST})
//    @ResponseBody
    public String test(@PathVariable(name = "id1") Integer id,@RequestParam String name) throws Exception {

        diana.q();

        throw new ForbiddenException(10001);
//        throw new Exception("dwewq");

//        return "0527_xl?12sd32ewewwew";
    }

    @PostMapping("/test2/{id1}")
    public String test(@PathVariable(name = "id1") @Range(min = 2,max = 9,message = "错了") Integer id, @RequestParam String name, @RequestBody @Validated PersionDTO persion) throws Exception {
//        PersionDTO persionDTO = new PersionDTO();
        diana.q();
        throw new ForbiddenException(10001);
//        throw new Exception("dwewq");

//        return "0527_xl?12sd32ewewwew";
    }
}
