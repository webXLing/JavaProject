package com.xl.missyou.api.v1;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import com.xl.missyou.bo.PageCounter;
import com.xl.missyou.exception.http.NotFoundException;
import com.xl.missyou.model.Spu;
import com.xl.missyou.service.SpuService;
import com.xl.missyou.util.CommonUtil;
import com.xl.missyou.vo.PagingDozer;
import com.xl.missyou.vo.SpuVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/spu")
@Validated
public class SpuController {

    @Autowired
    private SpuService spuService;
    @GetMapping("/id/{id}/detail")
//    @Positive 正整数
    public Spu getDetail(@PathVariable @Positive(message = "{id.positive}") Long id){
        System.out.println(id);
        Spu byId = spuService.getById(id);
        System.out.println(byId);
        if(byId==null){
            throw new NotFoundException(300004);
        }
        return byId;
    }

    @GetMapping("/lastest")
//    /lastest?start=0&count=20
//    List<SpuVO>
    public PagingDozer<Spu,SpuVO> getLatestSpuList(@RequestParam(defaultValue = "0") Integer start,
                                        @RequestParam(defaultValue = "20") Integer count){
//        BeanUtils.copyProperties();
        PageCounter pageCounter = CommonUtil.ConvertToPageParams(start,count);
        // 简化返回值
        Page<Spu> latestPagingSpu = this.spuService.getLatestPagingSpu(pageCounter.getPage(), pageCounter.getSize());
        // 封装后
        return  new PagingDozer<Spu,SpuVO>(latestPagingSpu,SpuVO.class);
        // 封装前
//        Mapper mapper = DozerBeanMapperBuilder.buildDefault();
//        List<SpuVO> vos = new ArrayList<>();
//        latestPagingSpu.forEach(spu -> {
//            SpuVO vo = mapper.map(spu,SpuVO.class);
//            vos.add(vo);
//        });
//        return vos;
    }

    @GetMapping("/by/category/{id}")
    public PagingDozer<Spu,SpuVO> getByCategoty(@PathVariable @Positive(message = "{id.positive}") Long id,
                                     @RequestParam(defaultValue = "0") Integer start,
                                     @RequestParam(defaultValue = "10") Integer count,
                                     @RequestParam(defaultValue = "false") Boolean isRoot
    ){
//        加start 转化为 page
        PageCounter pageCounter = CommonUtil.ConvertToPageParams(start, count);

        Page<Spu> byCategory = this.spuService.getByCategory(id, isRoot, pageCounter.getPage(), pageCounter.getSize());
        System.out.println(byCategory);
        return new PagingDozer<>(byCategory,SpuVO.class);
    }
}
