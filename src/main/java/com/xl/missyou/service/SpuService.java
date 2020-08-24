package com.xl.missyou.service;

import com.xl.missyou.model.Article;
import com.xl.missyou.model.Author;
import com.xl.missyou.model.Spu;
import com.xl.missyou.repository.ArticleRepository;
import com.xl.missyou.repository.AuthorRepository;
import com.xl.missyou.repository.SpuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpuService {
    @Autowired
    private SpuRepository spuRepository;


    public Spu getById(Long id){
        return spuRepository.findOneById(id);
    }


}
