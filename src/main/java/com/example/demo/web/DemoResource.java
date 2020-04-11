package com.example.demo.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoResource {

    @GetMapping(path = "/hello")
    public ResponseEntity<String> getHelloWorld() {
        return new ResponseEntity<String>("Hello world !", HttpStatus.OK);
    }
}
