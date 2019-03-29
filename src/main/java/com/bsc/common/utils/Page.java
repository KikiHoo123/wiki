package com.bsc.common.utils;

/**
 * @author YangRui
 */
public class Page {
    private Integer currentPage=1; //当前页数
    private Integer totalPages; //总页数
    private Integer totalUsers; //记录总行数
    private Integer pageSize=5; //每页记录行数
    private Integer nextPage; //下一页
    private Integer prefPage; //前一页

    public Integer getCurrentPage() {
        return currentPage;
    }
    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }
    public Integer getTotalPages() {
        totalPages = totalUsers % pageSize == 0 ? totalUsers / pageSize : totalUsers / pageSize + 1;
        return totalPages;
    }
    public Integer getTotalUsers() {
        return totalUsers;
    }
    public void setTotalUsers(Integer totalUsers) {
        this.totalUsers = totalUsers;
    }
    public Integer getPageSize() {
        return pageSize;
    }
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
    public Integer getNextPage() {
        if (currentPage < totalPages) {
            nextPage = currentPage + 1; }
        else {
            nextPage = currentPage; }
        return nextPage;
    }
    public Integer getPrefPage() {
        if (currentPage > 1) {
            prefPage = currentPage - 1;
        }
        else {
            prefPage = currentPage;
        }
        return prefPage;
    }
}
