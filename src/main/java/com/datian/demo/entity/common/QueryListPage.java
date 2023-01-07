package com.datian.demo.entity.common;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.datian.demo.entity.db.KeywordData;
import lombok.Data;

import java.util.Collections;
import java.util.List;

/**
 * @author hyx
 * @date 2023/1/5 19:09
 */
@Data
public class QueryListPage<T, E> {

    /**
     * 查询条件
     */
    private T query;

    /**
     * 总数
     */
    private Page<E> page;

}
