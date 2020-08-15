package com.example.demo.config;

import com.example.demo.metrics.MyJmxMeterRegistry;
import io.micrometer.core.instrument.Clock;
import io.micrometer.jmx.JmxConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JmxMetrics {

    private static final Logger logger = LoggerFactory.getLogger(JmxMetrics.class);

    @Bean
    public MyJmxMeterRegistry myJmxMeterRegistry(JmxConfig jmxConfig, Clock clock) {
        return new MyJmxMeterRegistry(jmxConfig, clock);
    }

}
