package com.datian.demo.entity.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.datian.demo.entity.db.KeywordData;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
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
public class KeywordDataDto extends KeywordData implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private String id;

    /**
     * 字典字段名称
     */
    @NotNull(message = "字典字段名称不能为空")
    private String dataName;

    /**
     * 字典解释
     */
    @NotNull(message = "字典解释不能为空")
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
