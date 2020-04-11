package com.example.demo.web;

import com.example.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/logback")
public class DemoResource {

    @Autowired
    DemoService demoService;

    @GetMapping(path = "/hello")
    public ResponseEntity<String> getHelloWorld() {
        demoService.testMyLogger("test");
        return new ResponseEntity<>("Hello world !", HttpStatus.OK);
    }
}
