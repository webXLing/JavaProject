package com.xl.missyou.repository;

import com.xl.missyou.model.Article;
import com.xl.missyou.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article,Long> {
    Article findOneById(Long id);
}
