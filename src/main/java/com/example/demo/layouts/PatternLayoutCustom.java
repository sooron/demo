package com.example.demo.layouts;

import ch.qos.logback.classic.PatternLayout;
import ch.qos.logback.classic.spi.ILoggingEvent;

public class PatternLayoutCustom  extends PatternLayout {

    /* this property will be set via logback.xml configuration file */
    private String flavor;

    @Override
    public String doLayout(ILoggingEvent event) {
        return doTransform(super.doLayout(event));
    }

    /* Message transformation */
    private String doTransform(String msg) {
        /* Do whatever transformation is needed here, remember log message ends with \n */
        String resultMsg = msg;
        switch (flavor) {
            case "fruits" :
                resultMsg = msg.replaceAll("DEBUG", "LEMON").replaceAll("INFO", "APPLE").replaceAll("WARN", "ORANGE").replaceAll("ERROR", "STRAWBERRY");
                break;
        }
        return resultMsg;
    }

    /* custom properties need setters to be set from configuration file logback.xml */
    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }
}
