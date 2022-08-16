package com.example.article.service;

import com.example.article.entity.Article;
import com.example.article.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

    public Article create(String title, String content, String writer, String password) {
        Article article = new Article(title, content, writer, password);
        return articleRepository.save(article);
    }
}
