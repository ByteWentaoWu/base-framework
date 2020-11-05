package com.open.base.core.mybatis;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.open.base.core.mvc.WhereEntity;
import org.springframework.util.CollectionUtils;

import java.util.List;

public class WrapperTool {


    /**
     * 批量构建查询条件
     *
     * @param queryWrapper
     * @param wheres
     * @param <T>
     * @return
     */
    public static <T> Wrapper<T> getQueryWrapper(QueryWrapper<T> queryWrapper, List<WhereEntity> wheres) {
        if (CollectionUtils.isEmpty(wheres)) {
            return queryWrapper;
        }
        wheres.forEach(e -> {
            getQueryWrapper(queryWrapper, e);
        });
        return queryWrapper;
    }

    /**
     * 构建查询 Wrapper
     * <p>
     * eq	等于=
     * ne	不等与<>
     * gt	大于>
     * ge	大于等于>=
     * lt	小于<
     * le	小于等于<=
     * like	模糊查询 LIKE
     * notLike	模糊查询 NOT LIKE
     * leftlike	左模糊查询
     * rightlike 右模糊查询
     * in	IN 查询
     * notIn	NOT IN 查询
     * isNull	NULL 值查询
     * isNotNull	IS NOT NULL
     * orderAsc 降序
     * orderAsc 升序
     * <p/>
     *
     * @param queryWrapper
     * @param where
     * @param <T>
     * @return
     */
    public static <T> Wrapper<T> getQueryWrapper(QueryWrapper<T> queryWrapper, WhereEntity where) {
        if (!"groupby".equals(where.getType()) || !"orderAsc".equals(where.getType()) || !"orderDesc".equals(where.getType())) {
            if (where.getValue() == null || "".equals(where.getValue())) {
                return queryWrapper;
            }
        }
        switch (where.getType()) {
            case "eq":
                queryWrapper.eq(where.getColumn(), where.getValue());
                break;
            case "ne":
                queryWrapper.ne(where.getColumn(), where.getValue());
                break;
            case "gt":
                queryWrapper.gt(where.getColumn(), where.getValue());
                break;
            case "lt":
                queryWrapper.lt(where.getColumn(), where.getValue());
                break;
            case "ge":
                queryWrapper.ge(where.getColumn(), where.getValue());
                break;
            case "le":
                queryWrapper.le(where.getColumn(), where.getValue());
            case "like":
                queryWrapper.like(where.getColumn(), where.getValue());
                break;
            case "notlike":
                queryWrapper.notLike(where.getColumn(), where.getValue());
                break;
            case "leftlike":
                queryWrapper.likeLeft(where.getColumn(), where.getValue());
                break;
            case "rightlike":
                queryWrapper.likeRight(where.getColumn(), where.getValue());
                break;
            case "orderAsc":
                queryWrapper.orderByAsc(where.getColumn());
                break;
            case "orderDesc":
                queryWrapper.orderByDesc(where.getColumn());
                break;
            case "groupby":
                queryWrapper.groupBy(where.getColumn());
                break;

        }
        return queryWrapper;
    }

}
