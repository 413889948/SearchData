package com.datian.demo.utils;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: huangyx
 * @Date: 2021/8/5 16:57
 *
 */
public class HttpUtil {


    /**
     * 进行post请求的封装工具
     * @param map 入参示例如下：
     *         MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
     *         map.add("group_id", groupId);
     *         map.add("message", DivinationUtil.get());
     * @param url 链接
     * @return 字符串类型
     */
    public static String post(MultiValueMap<String, Object> map, String url){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<>(map, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
        return response.getBody();
    }
}
