package com.datian.demo.entity.query;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.datian.demo.entity.db.KeywordData;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author hyx
 * @since 2022-03-26
 */
@Data
@Accessors(chain = true)
public class KeywordDataQuery extends KeywordData implements Serializable  {

    private static final long serialVersionUID = 1L;


}
