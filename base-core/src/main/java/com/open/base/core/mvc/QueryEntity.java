package com.open.base.core.mvc;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(value = "MVC查询参数实体", description = "查询条件")
public class QueryEntity {
    /**
     * 分页
     */
    private int page = 1;

    /**
     * 每页数量
     */
    private int limit = 10;

    /**
     * 查询条件
     */
    private List<WhereEntity> params;
}