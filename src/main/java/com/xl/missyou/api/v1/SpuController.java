package com.xl.missyou.api.v1;

import com.xl.missyou.exception.http.NotFoundException;
import com.xl.missyou.model.Spu;
import com.xl.missyou.service.SpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping("/spu")
public class SpuController {

    @Autowired
    private SpuService spuService;

    @Validated
    @GetMapping("/id/{id}/detail")
//    @Positive 正整数
    public Spu getDetail(@PathVariable @Positive Long id){
        System.out.println(id);
        Spu byId = spuService.getById(id);
        System.out.println(byId);
        if(byId==null){
            throw new NotFoundException(300004);
        }
        return byId;
    }

    @GetMapping("/lastest")
    public List<Spu> getLatestSpuList(){
      return  this.spuService.getLatestPagingSpu();
    }
}
