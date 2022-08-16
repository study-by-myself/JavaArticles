package com.example.article.dto;

public class ArticleCreateRequestDto {
    private String title;
    private String content;
    private String writer;
    private String password;

    public ArticleCreateRequestDto(String title, String content, String writer, String password) {
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.password = password;
    }


    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getWriter() {
        return writer;
    }

    public String getPassword() {
        return password;
    }
}
