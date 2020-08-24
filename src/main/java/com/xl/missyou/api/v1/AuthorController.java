package com.xl.missyou.api.v1;

import com.xl.missyou.model.Article;
import com.xl.missyou.model.Author;
import com.xl.missyou.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author/")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("by/id")
    public Author getById(@RequestParam Long id){
        System.out.println("author controller");
        Author byId = authorService.getById(id);
        System.out.println(byId);
//        return null;
        return byId;
    }

    @GetMapping("/article/by/id")
    public Article getArById(@RequestParam Long id){
        System.out.println("article controller");
        Article byId = authorService.getArticleById(id);
        System.out.println(byId);
//        return null;
        return byId;
    }
}
