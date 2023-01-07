package com.datian.demo.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.datian.demo.entity.common.QueryListPage;
import com.datian.demo.entity.db.KeywordData;
import com.datian.demo.entity.query.KeywordDataQuery;
import com.datian.demo.entity.vo.KeywordDataVo;

import java.util.List;

/**
 * (EightSymbol)表服务接口
 *
 * @author makejava
 * @since 2021-07-23 16:02:47
 */
public interface KeywordDataService extends IService<KeywordData> {

    /**
     * 查询字典数据
     */
    Page<KeywordDataVo> listKeywordData(QueryListPage<KeywordDataQuery, KeywordData> data);

    /**
     * 新增修改字典数据
     */
    Boolean addUpdateKeywordData(KeywordData data);


}
