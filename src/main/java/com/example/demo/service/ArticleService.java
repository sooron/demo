package com.example.demo.service;

import com.example.demo.domain.Article;
import com.example.demo.repository.ArticleRepository;
import com.example.demo.repository.ComplexTransactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class ArticleService {

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    ComplexTransactions complexTransactions;

    public String createArticle() {
        Article article = new Article();
        article.setDescription("Description");
        articleRepository.save(article);
        return article.toString();
    }

    public String updateArticles() {
        try {
            complexTransactions.updateArticles(null, null, null);
        } catch (SQLException e) {
            return "update is ko";
        }
        return "update is ok";
    }
}
