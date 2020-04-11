package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DemoService {
    private final static Logger logger = LoggerFactory.getLogger(DemoService.class);

    public void testMyLogger(String msg) {
        logger.debug("Message is {}", msg);
        logger.info("Message is {}", msg);
        logger.warn("Message is {}", msg);
        logger.error("Message is {}", msg);
        logger.trace("Message is {}", msg);
    }
}
