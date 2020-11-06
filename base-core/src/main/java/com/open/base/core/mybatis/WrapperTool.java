package com.open.base.core.mybatis;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.open.base.core.mvc.WhereEntity;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * MyBatis Plus Wrapper 工具类
 *
 * @author Wentao.Wu
 * @date 2020-11-05
 */
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

    private static final String EQ = "eq";
    private static final String NE = "ne";
    private static final String GT = "gt";
    private static final String GE = "ge";
    private static final String LT = "lt";
    private static final String LE = "le";
    private static final String LIKE = "like";
    private static final String NOTLIKE = "notlike";
    private static final String LEFTLIKE = "leftlike";
    private static final String RIGHTLIKE = "rightlike";
    private static final String IN = "in";
    private static final String NOT_IN = "notIn";
    private static final String IS_NULL = "isNull";
    private static final String IS_NOT_NULL = "isNotNull";
    private static final String ORDER_ASC = "orderAsc";
    private static final String ORDER_DESC = "orderDesc";
    private static final String GROUP_BY = "groupBy";


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
     * orderDesc 升序
     * <p/>
     *
     * @param queryWrapper
     * @param where
     * @param <T>
     * @return
     */
    public static <T> Wrapper<T> getQueryWrapper(QueryWrapper<T> queryWrapper, WhereEntity where) {
        if (!GROUP_BY.equals(where.getType()) || !ORDER_ASC.equals(where.getType()) || !ORDER_DESC.equals(where.getType())
                || !IS_NOT_NULL.equals(where.getType()) || !IS_NULL.equals(where.getType())) {
            if (where.getValue() == null || "".equals(where.getValue())) {
                return queryWrapper;
            }
        }
        switch (where.getType()) {
            case EQ:
                queryWrapper.eq(where.getColumn(), where.getValue());
                break;
            case NE:
                queryWrapper.ne(where.getColumn(), where.getValue());
                break;
            case GT:
                queryWrapper.gt(where.getColumn(), where.getValue());
                break;
            case LT:
                queryWrapper.lt(where.getColumn(), where.getValue());
                break;
            case GE:
                queryWrapper.ge(where.getColumn(), where.getValue());
                break;
            case LE:
                queryWrapper.le(where.getColumn(), where.getValue());
            case LIKE:
                queryWrapper.like(where.getColumn(), where.getValue());
                break;
            case NOTLIKE:
                queryWrapper.notLike(where.getColumn(), where.getValue());
                break;
            case LEFTLIKE:
                queryWrapper.likeLeft(where.getColumn(), where.getValue());
                break;
            case RIGHTLIKE:
                queryWrapper.likeRight(where.getColumn(), where.getValue());
                break;
            case IN:
                queryWrapper.in(where.getColumn(), where.getValue());
                break;
            case NOT_IN:
                queryWrapper.notIn(where.getColumn(), where.getValue());
                break;
            case IS_NULL:
                queryWrapper.isNull(where.getColumn());
                break;
            case IS_NOT_NULL:
                queryWrapper.isNotNull(where.getColumn());
                break;
            case ORDER_ASC:
                queryWrapper.orderByAsc(where.getColumn());
                break;
            case ORDER_DESC:
                queryWrapper.orderByDesc(where.getColumn());
                break;
            case GROUP_BY:
                queryWrapper.groupBy(where.getColumn());
                break;

        }
        return queryWrapper;
    }

}
