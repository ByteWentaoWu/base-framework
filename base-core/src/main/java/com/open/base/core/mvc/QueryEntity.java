package com.open.base.core.mvc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;


@Data
@ApiModel(value = "MVC查询参数实体", description = "查询条件")
public class QueryEntity {
    /**
     * 分页
     */
    @ApiModelProperty(value = "当前页(默认1)", name = "page", required = false)
    private int page = 1;

    /**
     * 每页数量
     */
    @ApiModelProperty(value = "每页数量(默认10)", name = "page", required = false)
    private int limit = 10;

    /**
     * 查询条件
     */
    private List<WhereEntity> params;
}