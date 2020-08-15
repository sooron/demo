package com.example.demo.metrics;

import com.codahale.metrics.MetricRegistry;
import io.micrometer.core.instrument.Clock;
import io.micrometer.core.instrument.dropwizard.DropwizardMeterRegistry;
import io.micrometer.core.instrument.util.HierarchicalNameMapper;
import io.micrometer.jmx.JmxConfig;

public class MyJmxMeterRegistry extends DropwizardMeterRegistry {
    private final MyJmxReporter reporter;

    public MyJmxMeterRegistry(JmxConfig config, Clock clock) {
        this(config, clock, HierarchicalNameMapper.DEFAULT);
    }

    public MyJmxMeterRegistry(JmxConfig config, Clock clock, HierarchicalNameMapper nameMapper) {
        this(config, clock, nameMapper, new MetricRegistry());
    }

    public MyJmxMeterRegistry(JmxConfig config, Clock clock, HierarchicalNameMapper nameMapper, MetricRegistry metricRegistry) {
        this(config, clock, nameMapper, metricRegistry, defaultJmxReporter(config, metricRegistry));
    }

    public MyJmxMeterRegistry(JmxConfig config, Clock clock, HierarchicalNameMapper nameMapper, MetricRegistry metricRegistry, MyJmxReporter jmxReporter) {
        super(config, metricRegistry, nameMapper, clock);
        this.reporter = jmxReporter;
        this.reporter.start();
    }

    private static MyJmxReporter defaultJmxReporter(JmxConfig config, MetricRegistry metricRegistry) {
        return MyJmxReporter.forRegistry(metricRegistry).inDomain(config.domain()).build();
    }

    public void stop() {
        this.reporter.stop();
    }

    public void start() {
        this.reporter.start();
    }

    public void close() {
        this.stop();
        super.close();
    }

    protected Double nullGaugeValue() {
        return Double.NaN;
    }
}