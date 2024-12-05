package com.example.query;

import com.baomidou.mybatisplus.core.metadata.OrderItem;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;

@Data
@Accessors(chain = true)
public class PageQuery {
    public static final Integer DEFAULT_PAGE_SIZE = 20;//默认每页显示20条
    public static final Integer DEFAULT_PAGE_NUM = 1;//默认第一页
   
    /**
     * 当前页
     */
    private Integer currentPage = DEFAULT_PAGE_NUM;
   
    /**
     * 每页打大小
     */
    private Integer pageSize = DEFAULT_PAGE_SIZE;
   
    /**
     * 是否是升序排序
     */
    private Boolean isAsc = true;
   
    /**
     * 排序字段
     */
    private String sortBy;
   
    public int from(){
        return (currentPage - 1) * pageSize;
    }
   
    /**
     * 添加多个排序条件
     */
    public <T> Page<T> toMpPage(OrderItem... orderItems) {
        Page<T> page = new Page<>(currentPage, pageSize);
        // 是否手动指定排序方式
        if (orderItems != null && orderItems.length > 0) {
            for (OrderItem orderItem : orderItems) {
                page.addOrder(orderItem);
            }
            return page;
        }
        // 前端是否有排序字段
        if (StringUtils.isNotEmpty(sortBy)){
            OrderItem orderItem = new OrderItem();
            orderItem.setAsc(isAsc);
            orderItem.setColumn(sortBy);
            page.addOrder(orderItem);
        }
        return page;
    }
   
    /**
     * 添加默认排序条件
     * @param defaultSortBy 默认排序字段
     * @param isAsc 是否升序
     */
    public <T> Page<T> toMpPage(String defaultSortBy, boolean isAsc) {
        if (StringUtils.isBlank(sortBy)){
            sortBy = defaultSortBy;
            this.isAsc = isAsc;
        }
        Page<T> page = new Page<>(currentPage, pageSize);
        OrderItem orderItem = new OrderItem();
        orderItem.setAsc(this.isAsc);
        orderItem.setColumn(sortBy);
        page.addOrder(orderItem);
        return page;
    }
   
    /**
     * 设置默认排序字段
     */
    public <T> Page<T> toMpPageDefaultSortByCreateTimeDesc() {
        return toMpPage("create_time", false);
    }
}