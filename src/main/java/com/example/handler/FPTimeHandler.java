package com.example.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 全局时间填充
 */
@Component//需要在依赖项目中开启扫描
public class FPTimeHandler implements MetaObjectHandler {

    /**
     * 新增填充
     * @param metaObject 元对象
     */
    @Override
    public void insertFill(MetaObject metaObject) {

        if (metaObject.hasSetter("createTime")) {
            metaObject.setValue("createTime", LocalDateTime.now());
        }

        if (metaObject.hasSetter("updateTime")) {
            metaObject.setValue("updateTime", LocalDateTime.now());
        }
    }

    /**
     * 更新填充
     * @param metaObject 元对象
     */
    @Override
    public void updateFill(MetaObject metaObject) {

        if (metaObject.hasSetter("updateTime")) {
            metaObject.setValue("updateTime",LocalDateTime.now());
        }
    }
}