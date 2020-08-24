package com.xl.missyou.service;

import com.xl.missyou.model.Article;
import com.xl.missyou.model.Author;
import com.xl.missyou.repository.ArticleRepository;
import com.xl.missyou.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    private ArticleRepository articleRepository;

    public Author getById(Long id){
        return authorRepository.findOneById(id);
    }

    public Article getArticleById(Long id){
        return articleRepository.findOneById(id);
    }

}
