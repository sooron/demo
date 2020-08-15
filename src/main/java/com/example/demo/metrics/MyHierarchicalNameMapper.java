package com.example.demo.metrics;

import io.micrometer.core.instrument.Meter;
import io.micrometer.core.instrument.config.NamingConvention;
import io.micrometer.core.instrument.util.HierarchicalNameMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyHierarchicalNameMapper implements HierarchicalNameMapper {

    private static final Logger logger = LoggerFactory.getLogger(MyHierarchicalNameMapper.class);

    @Override
    public String toHierarchicalName(Meter.Id id, NamingConvention namingConvention) {
        logger.info("providing name for meter : {}", id.getBaseUnit());
        return id.getName();
    }
}
