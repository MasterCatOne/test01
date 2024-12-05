package com.example.model.vo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

public class PageVO<T> {
   
    /**
     * 当前页码
     */
    private Long currentPage;
   
    /**
     * 每页显示的数量
     */
    private Long pageSize;
   
    /**
     * 总记录数
     */
    private Long totalCount;
   
    /**
     * 总页数
     */
    private Long totalPages;
   
    /**
     * 数据列表
     */
    private List<T> dataList;
   
   
    // Getter 和 Setter 方法
    public Long getCurrentPage() {
        return currentPage;
    }
   
    public void setCurrentPage(Long currentPage) {
        this.currentPage = currentPage;
    }
   
    public Long getPageSize() {
        return pageSize;
    }
   
    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }
   
   
    public long getTotalCount() {
        return totalCount;
    }
   
    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
        // 如果总记录数有变化，可能需要重新计算总页数
        this.totalPages = totalCount / pageSize;
    }
   
    public Long getTotalPages() {
        return totalPages;
    }
   
    // 注意：totalPages 的 setter 方法不需要，因为是通过 totalCount 和 pageSize 计算得出的
   
    public List<T> getDataList() {
        return dataList;
    }
   
    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }
   
    public void of(Page<T> page) {
        this.setCurrentPage(page.getCurrent());
        this.setPageSize(page.getSize());
        this.setTotalCount(page.getTotal());
        this.setDataList(page.getRecords());
    }
}