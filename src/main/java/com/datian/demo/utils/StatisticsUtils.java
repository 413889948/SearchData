package com.datian.demo.utils;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;

/**
 * @author guanyf
 **/
public class StatisticsUtils {

    /**
     * 保留小数位
     */
    public static final int KEEP_DECIMAL_PLACES = 2;

    /**
     * 统计表保留 ? 位小数
     */
    public static String twoDecimalPlaces(String number) {
        if (StringUtils.isBlank(number)) {
            number = "0";
        }
        return new BigDecimal(number).setScale(KEEP_DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP).toString();
    }



}
