package com.xl.missyou.service;

import com.xl.missyou.model.Article;
import com.xl.missyou.model.Author;
import com.xl.missyou.model.Spu;
import com.xl.missyou.repository.ArticleRepository;
import com.xl.missyou.repository.AuthorRepository;
import com.xl.missyou.repository.SpuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpuService {
    @Autowired
    private SpuRepository spuRepository;


    public Spu getById(Long id){
        return spuRepository.findOneById(id);
    }


//    public List<Spu> getLatestPagingSpu(){
//        return this.spuRepository.findAll();
//    }
    // 分页查询
    // 查询最新的spu 商品 分页
    public Page<Spu> getLatestPagingSpu(Integer pageNum, Integer pageSize){
        // Sort 根据的createTime 排序  字段名是 model的 字段名 不是数据库的
        PageRequest pageable = PageRequest.of(pageNum, pageSize, Sort.by("createTime").descending());
        return this.spuRepository.findAll(pageable);
    }

//    通过分类id查询spu（商品类）

    /**
     *
     * @param cid  分类id
     * @param isRoot 是否是一级分类
     * @return
     */
    public Page<Spu> getByCategory(Long cid,Boolean isRoot,Integer pageNum, Integer pageSize) {
        PageRequest page = PageRequest.of(pageNum, pageSize);
        if(isRoot){
          return this.spuRepository.findByRootCategoryIdOrderByCreateTime(cid,page);
        }else{
            return  this.spuRepository.findByCategoryIdOrderByCreateTimeDesc(cid,page);
        }
    }
}
