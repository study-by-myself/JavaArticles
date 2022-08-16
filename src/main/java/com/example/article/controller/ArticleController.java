package com.example.article.controller;

import com.example.article.dto.ArticleCreateRequestDto;
import com.example.article.entity.Article;
import com.example.article.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ArticleController {
    private final ArticleService articleService;


    @PostMapping("/api/articles")
    public Article createArticle(@RequestBody ArticleCreateRequestDto requestDto) {

        String title = requestDto.getTitle();
        String content = requestDto.getContent();
        String writer = requestDto.getWriter();
        String password = requestDto.getPassword();

        return articleService.create(title, content, writer, password);
    }

}
