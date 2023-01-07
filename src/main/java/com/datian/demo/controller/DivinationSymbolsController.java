package com.datian.demo.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.datian.demo.entity.common.QueryListPage;
import com.datian.demo.entity.db.KeywordData;
import com.datian.demo.entity.dto.KeywordDataDto;
import com.datian.demo.entity.query.KeywordDataQuery;
import com.datian.demo.entity.vo.KeywordDataVo;
import com.datian.demo.service.KeywordDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;

import javax.validation.Valid;
import java.util.List;

/**
 * @Author: huangyx
 * @Date: 2021/7/22 10:14
 */
@Controller
@CrossOrigin
@Api(tags = "字典数据")
public class DivinationSymbolsController {

    @Autowired
    private KeywordDataService keywordDataService;

    @ResponseBody
    @RequestMapping(value = "/listKeywordData", method = RequestMethod.POST)
    public Page<KeywordDataVo> listKeywordData(@RequestBody QueryListPage<KeywordDataQuery, KeywordData> data) {
        return keywordDataService.listKeywordData(data);
    }

    @ResponseBody
    @RequestMapping(value = "/addUpdateKeywordData", method = RequestMethod.POST)
    public Boolean addUpdateKeywordData(@Valid @RequestBody KeywordDataDto data) {
        return keywordDataService.addUpdateKeywordData(JSON.parseObject(JSON.toJSONString(data), KeywordData.class));
    }
}
