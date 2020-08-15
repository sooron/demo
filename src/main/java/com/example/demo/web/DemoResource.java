package com.example.demo.web;

import com.example.demo.metrics.MyHierarchicalNameMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoResource {

    private static final Logger logger = LoggerFactory.getLogger(DemoResource.class);

    @GetMapping(path = "/hello")
    public ResponseEntity<String> getHelloWorld() {
        logger.info("Hello world !");
        return new ResponseEntity<String>("Hello world !", HttpStatus.OK);
    }
}
