package com.open.base.core.mvc;

import com.baomidou.mybatisplus.extension.service.IService;
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
    T getById(@PathVariable("id") Serializable pk) {
        return service.getById(pk);
    }

    @PutMapping
    boolean update(T t) {
        return service.updateById(t);
    }

    @PostMapping
    boolean save(T t) {
        return service.save(t);
    }

    @DeleteMapping("/{id}")
    boolean delete(@PathVariable("id") Serializable pk) {
        return service.removeById(pk);
    }


}
