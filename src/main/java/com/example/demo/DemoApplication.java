package com.example.demo;

import io.micrometer.jmx.JmxMeterRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class DemoApplication {

    @Autowired
    ApplicationContext context;

    private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @PostConstruct
    private void configureApplication() {
        logger.info("Application initialized, configuring it post construct");

        try {
            JmxMeterRegistry autoconfiguredJmxMeterRegistry = context.getBean(JmxMeterRegistry.class);
            logger.info(">>> Autoconfigured JmxMeterRegistry bean found, stopping it");
            autoconfiguredJmxMeterRegistry.close();
        } catch (BeansException e) {
            logger.info(">>> No JmxMeterRegistry bean found");
        }
    }
}
