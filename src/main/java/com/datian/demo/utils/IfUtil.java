package com.datian.demo.utils;

import lombok.Data;

/**
 * @Author: huangyx
 * @Date: 2021/8/5 17:38
 *
 */
@Data
public class IfUtil {
    private Boolean flag;
    public IfUtil and(Boolean bol) {
        if (!(flag && bol)) {
            flag = false;
        }
        return this;
    }

    public IfUtil or(Boolean bol) {
        flag = flag || bol;
        return this;
    }
    public void test(){
        System.out.println("调用了方法");
    }
}
