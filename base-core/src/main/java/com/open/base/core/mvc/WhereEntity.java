package com.open.base.core.mvc;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@ApiModel(value = "条件实体类", description = "查询条件实体类用于动态生成MyBatis Wrapper")
public class WhereEntity {
    @ApiModelProperty(value = "列名", name = "column", required = true)
    private String column;

    @ApiModelProperty(value = "操作类型", name = "type", required = true)
    private String type;

    @ApiModelProperty(value = "值", name = "type", required = true)
    private Object value;
}
