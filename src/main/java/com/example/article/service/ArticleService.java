package com.example.article.service;

import com.example.article.dto.ArticleWriteRequestDto;
import com.example.article.entity.Article;
import com.example.article.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

    public Article create(String title, String content, String writer, String password) {
        Article article = new Article(title, content, writer, password);
        return articleRepository.save(article);
    }

    public List<Article> findAll() {
        return articleRepository.findAllByOrderByCreatedAtDesc();
    }

    public Optional<Article> findBy(Long id) {
        return articleRepository.findById(id);
    }

    public boolean checkPassword(Long id, String password) {
        Optional<Article> article = articleRepository.findById(id);
        return article.map(value -> value.getPassword().equals(password)).orElse(false);
    }

    public Article update(Long id, ArticleWriteRequestDto articleDto) {
        Optional<Article> article = articleRepository.findById(id);

        if (!article.isPresent()) {
            return null;
        }

        article.get().edit(articleDto);
        return articleRepository.save(article.get());
    }

    public String delete(Long id, String password) {
        Optional<Article> article = articleRepository.findById(id);
        if (article.isPresent() && article.get().getPassword().equals(password)) {
            articleRepository.deleteById(id);
            return "성공!";
        }
        return "실패";
    }
}
