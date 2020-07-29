package com.xl.missyou.api.v1;

import com.xl.missyou.dto.PersionDTO;
import com.xl.missyou.exception.http.ForbiddenException;
import com.xl.missyou.model.Banner;
import com.xl.missyou.sample.hero.Diana;
import com.xl.missyou.service.BannerService;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;

//@Controller
//@ResponseBody
@RestController()
@RequestMapping("/banner/")
//@Lazy
@Validated
public class BannerController {

    @Autowired
    private Diana diana;

    @Autowired
    private BannerService bannerService;

    @GetMapping("/name/{name}")
    @ResponseBody
    public Banner getByName(@PathVariable @NotBlank String name){
        Banner banner = bannerService.getByName(name);
        return banner;
    }


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
    public String test(@PathVariable(name = "id1") @Range(min = 2,max = 9,message = "2-9之间") Integer id, @RequestParam String name, @RequestBody @Validated PersionDTO persion) throws Exception {
//        PersionDTO persionDTO = new PersionDTO();
        diana.q();
        throw new ForbiddenException(10001);
//        throw new Exception("dwewq");

//        return "0527_xl?12sd32ewewwew";
    }
}
