package com.open.base.core.mvc;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.open.base.core.mybatis.WrapperTool;
import com.open.base.core.spring.SpringContextHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * Base Controller
 *
 * @author Wentao.Wu
 * @version 1.0
 * @date 2020/11/4 17:27
 */
public abstract class BaseController<E extends IService<T>, T> {

    @Autowired
    private E service;

    @GetMapping("/{id}")
    public T getById(@PathVariable("id") Serializable pk) {
        return service.getById(pk);
    }

    @PutMapping
    public boolean update(T t) {
        return service.updateById(t);
    }

    @PostMapping
    public boolean save(T t) {
        return service.save(t);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") Serializable pk) {
        return service.removeById(pk);
    }

    @PostMapping("/list")
    public IPage<T> list(@RequestBody QueryEntity param) {
        IPage<T> pageParam = new Page<>(param.getPage(), param.getLimit());
        Wrapper<T> queryWrapper = WrapperTool.getQueryWrapper(new QueryWrapper<T>(), param.getParams());
        return service.getBaseMapper().selectPage(pageParam, queryWrapper);
    }

}
