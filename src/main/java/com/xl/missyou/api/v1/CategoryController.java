package com.xl.missyou.api.v1;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category/")
public class CategoryController {

    @GetMapping("grid/all")
   public String getAll(){
        return "xl";
    }
}
