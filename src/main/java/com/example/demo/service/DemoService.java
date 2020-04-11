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

        /* Test for log transformation of json attributes */
        logger.debug("Test for json transformation of {\"test\": \"total\", \"logo\": \"AAAA\", \"cas\": 1}");
        logger.debug("Test for json transformation of {'test': 'total', 'logo': 'AAAA', 'cas': 2}");
        logger.debug("Test for json transformation of {test: total, logo: AAAA, cas: 3 }");
        logger.debug("Test for json transformation of {\n\ttest: total,\n\tlogo: AAAA,\n\tcas: 4\n}");
    }
}
