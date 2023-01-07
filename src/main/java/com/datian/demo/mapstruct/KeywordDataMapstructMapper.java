package com.datian.demo.mapstruct;

import com.datian.demo.entity.db.KeywordData;
import com.datian.demo.entity.vo.KeywordDataVo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author hyx
 * @date 2023/1/5 20:05
 */
@Mapper
public interface KeywordDataMapstructMapper {
    KeywordDataMapstructMapper INSTANCE = Mappers.getMapper(KeywordDataMapstructMapper.class);

    KeywordDataVo toKeywordDataVo(KeywordData keywordData);

}
