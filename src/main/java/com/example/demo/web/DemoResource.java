package com.example.demo.web;

import com.example.demo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoResource {

    @Autowired
    ArticleService articleService;

    @GetMapping(path = "/hello")
    public ResponseEntity<String> getHelloWorld() {
        return new ResponseEntity<String>("Hello world !", HttpStatus.OK);
    }

    @GetMapping(path = "/article")
    @Transactional
    public ResponseEntity<String> postNewArticle() {
        return new ResponseEntity<String>(articleService.createArticle(), HttpStatus.CREATED);
    }

    @GetMapping(path = "/update")
    @Transactional
    public ResponseEntity<String> updateArticles() {
        return new ResponseEntity<String>(articleService.updateArticles(), HttpStatus.OK);
    }
}
