package com.example.article.controller;

import com.example.article.dto.ArticleWriteRequestDto;
import com.example.article.dto.CheckPasswordRequestDto;
import com.example.article.entity.Article;
import com.example.article.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class ArticleController {
    private final ArticleService articleService;


    @PostMapping("/api/articles")
    public Article createArticle(@RequestBody ArticleWriteRequestDto requestDto) {

        String title = requestDto.getTitle();
        String content = requestDto.getContent();
        String writer = requestDto.getWriter();
        String password = requestDto.getPassword();

        return articleService.create(title, content, writer, password);
    }

    @GetMapping("/api/articles")
    public List<Article> listArticle() {
        return articleService.findAll();
    }

    @GetMapping("/api/articles/{id}")
    public Optional<Article> getArticle(@PathVariable Long id) {
        return articleService.findBy(id);
    }

    @PostMapping("/api/articles/{id}")
    public boolean checkPassword(@PathVariable Long id, @RequestBody CheckPasswordRequestDto passwordDto) {
        return articleService.checkPassword(id, passwordDto.getPassword());
    }

    @PutMapping("/api/articles/{id}")
    public Article editArticle(@PathVariable Long id, @RequestBody ArticleWriteRequestDto articleDto) {
        return articleService.update(id, articleDto);
    }

    @DeleteMapping("/api/articles/{id}")
    public String deleteArticle(@PathVariable Long id, @RequestBody CheckPasswordRequestDto passwordDto) {
        return articleService.delete(id, passwordDto.getPassword());
    }

}
