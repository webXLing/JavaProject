package com.xl.missyou.api.v1;


import com.xl.missyou.exception.http.NotFoundException;
import com.xl.missyou.model.Category;
import com.xl.missyou.model.GridCategory;
import com.xl.missyou.repository.CategoryRepository;
import com.xl.missyou.service.CategoryService;
import com.xl.missyou.service.GridCategoryService;
import com.xl.missyou.vo.CategoriesAllVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/category/")
//@ResponseBody
public class CategoryController {
    @GetMapping("grid/all1")
    public String getAll1(){
        return "xl";
    }

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private GridCategoryService gridCategoryService;

//    CategoriesAllVO 作用是为了处理成前端想要的数据
    @GetMapping("all")
    public CategoriesAllVO getAll(){
        Map<Integer, List<Category>> all = categoryService.getAll();
        return new CategoriesAllVO(all);
    }

    @GetMapping("/grid/all")
    public List<GridCategory> getGridCategoryList(){
        List<GridCategory> all = gridCategoryService.getAll();
        if(all==null){
            throw new NotFoundException(30009);
        }
        return  all;
    }
}
