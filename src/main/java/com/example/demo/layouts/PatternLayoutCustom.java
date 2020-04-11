package com.example.demo.layouts;

import ch.qos.logback.classic.PatternLayout;
import ch.qos.logback.classic.spi.ILoggingEvent;

public class PatternLayoutCustom  extends PatternLayout {
    @Override
    public String doLayout(ILoggingEvent event) {
        return doTransform(super.doLayout(event));
    }

    /* Message transformation */
    private String doTransform(String msg) {
        /* Do whatever transformation is needed here, remember log message ends with \n */
        String resultMsg = msg.replaceAll("DEBUG", "LEMON").replaceAll("INFO", "APPLE").replaceAll("WARN", "ORANGE").replaceAll("ERROR", "STRAWBERRY");
        String noLogoMsg = "";
        int logoPosition = resultMsg.indexOf("logo");
        if ( logoPosition > 0 ) {
            int preCommaPosition = resultMsg.substring(0, logoPosition).lastIndexOf(",");
            int postCommaPosition = resultMsg.substring(logoPosition).indexOf(',');
            int postCrPosition = resultMsg.substring(logoPosition).indexOf('\n');
            /* Should be default, where logo is in the middle of the json string */
            if ( preCommaPosition > 0 && postCommaPosition > 0 ) {
                noLogoMsg = resultMsg.substring(0, preCommaPosition + 1).concat(resultMsg.substring( logoPosition + postCommaPosition + 1 ));
            }
            /* Logo is at the beginning of the line */
            else if ( preCommaPosition == 0 && postCommaPosition > 0 ){
                noLogoMsg = resultMsg.substring(0, logoPosition).concat(resultMsg.substring( logoPosition + postCommaPosition + 1 ));
            }
            /* Logo is at the end of the line */
            else if ( preCommaPosition > 0 && postCommaPosition == 0 ) {
                if ( postCrPosition > 0 ) {
                    noLogoMsg = resultMsg.substring(0, logoPosition).concat(resultMsg.substring( logoPosition + postCrPosition ));
                } else {
                    noLogoMsg = resultMsg.substring(0, logoPosition).concat("\n");
                }
            }
            /* Logo is alone on the line */
            else {
                if ( postCrPosition > 0 ) {
                    noLogoMsg = resultMsg.substring(0, logoPosition).concat(resultMsg.substring( logoPosition + postCrPosition ));
                } else {
                    noLogoMsg = resultMsg.substring(0, logoPosition).concat("\n");
                }
            }
        }
        /* No logo on the line */
        else {
            noLogoMsg = resultMsg;
        }
        return noLogoMsg;
    }
}
