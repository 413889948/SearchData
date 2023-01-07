package com.datian.demo.service.impl;


import cn.hutool.core.convert.Convert;
import cn.hutool.core.lang.TypeReference;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.IdUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.datian.demo.dao.KeywordDataMapper;
import com.datian.demo.entity.common.QueryListPage;
import com.datian.demo.entity.db.KeywordData;
import com.datian.demo.entity.query.KeywordDataQuery;
import com.datian.demo.entity.vo.KeywordDataVo;
import com.datian.demo.mapstruct.KeywordDataMapstructMapper;
import com.datian.demo.service.KeywordDataService;
import org.apache.commons.lang3.StringUtils;
import org.mapstruct.BeanMapping;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * (EightSymbol)表服务实现类
 *
 * @author makejava
 * @since 2021-07-23 16:02:47
 */
@Service("KeywordDataService")
public class KeywordDataServiceImpl extends ServiceImpl<KeywordDataMapper, KeywordData> implements KeywordDataService {
    @Autowired
    private KeywordDataMapper keywordDataMapper;

    @Override
    public Page<KeywordDataVo> listKeywordData(QueryListPage<KeywordDataQuery, KeywordData> data) {

        QueryWrapper<KeywordData> queryWrapper = new QueryWrapper<>();
        KeywordDataQuery query = data.getQuery();
        if (StringUtils.isNotBlank(query.getDataName())) {
            queryWrapper.like("DATA_NAME", query.getDataName());
        }
        queryWrapper.eq("DEL", "0");
        Page<KeywordData> page = keywordDataMapper
                .selectPage(new Page<>(data.getPage().getCurrent(), data.getPage().getSize()), queryWrapper);
        Page<KeywordDataVo> record = new Page<>(page.getCurrent(), page.getSize(), page.getTotal());
        record.setRecords(JSON.parseArray(JSON.toJSONString(page.getRecords()), KeywordDataVo.class));
        return record;
    }

    @Override
    public Boolean addUpdateKeywordData(KeywordData data) {
        if (StringUtils.isBlank(data.getId())) {
            data.setId(IdUtil.simpleUUID());
        }
        return this.saveOrUpdate(data);
    }
}
