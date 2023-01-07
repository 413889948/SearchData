package com.datian.demo.entity.db;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("y_data")
public class KeywordData implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    private String id;

    /**
     * 字典字段名称
     */
    private String dataName;

    /**
     * 字典解释
     */
    private String dataExplain;

    /**
     * 备注
     */
    private String dataRemark;

    /**
     * 删除标识
     */
    private String del = "0";


}
