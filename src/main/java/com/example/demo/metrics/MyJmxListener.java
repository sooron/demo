package com.example.demo.metrics;

import com.codahale.metrics.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyJmxListener implements MetricRegistryListener {

    private static final Logger logger = LoggerFactory.getLogger(MyJmxListener.class);

    @Override
    public void onGaugeAdded(String s, Gauge<?> gauge) {
        logger.info("Added gauge {}", s);
    }

    @Override
    public void onGaugeRemoved(String s) {
        logger.info("Removed gauge {}", s);
    }

    @Override
    public void onCounterAdded(String s, Counter counter) {
        logger.info("Added counter {}", s);
    }

    @Override
    public void onCounterRemoved(String s) {
        logger.info("Removed counter {}", s);
    }

    @Override
    public void onHistogramAdded(String s, Histogram histogram) {
        logger.info("Added histogram {}", s);
    }

    @Override
    public void onHistogramRemoved(String s) {
        logger.info("Removed histogram {}", s);
    }

    @Override
    public void onMeterAdded(String s, Meter meter) {
        logger.info("Added meter {}", s);
    }

    @Override
    public void onMeterRemoved(String s) {
        logger.info("Removed meter {}", s);
    }

    @Override
    public void onTimerAdded(String s, Timer timer) {
        logger.info("Added timer {}", s);
    }

    @Override
    public void onTimerRemoved(String s) {
        logger.info("Removed timer {}", s);
    }
}
