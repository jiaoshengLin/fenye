package com.qf.entity;

import java.util.List;

public class PageBean <T>{
    //当前页码
    private int pageNum ;
    //每页显示条数
    private int pageSize ;
    //总记录数
    private int totalCount;
    //总页数
    private int totalPage;
    //包含分页对象的集合
    List<T> list = null;
    //分页条起始页码
    private int startIndex;
    //分页条结束页码
    private int endIndex;
    //分页条
    private String pageStr;

    /**
     * mysql数据库 需要分页参数
     * 启示索引
     */
    private int start;

    public PageBean(int pageNum, int pageSize, int totalCount, List<T> list) {
        //计算总页数
        this.totalPage = totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
        //计算当前页码
        if(pageNum>0&&pageNum<=this.totalPage){
            this.pageNum = pageNum;
        }else{
            this.pageSize = 1;
        }
        //设置每页显示条数
        if (pageSize>0&&pageSize<=totalCount){
            this.pageSize = pageSize;
        }else {
            this.pageSize = 10;
        }
        this.totalCount = totalCount;
        this.list = list;
        /*
            设置起始页码和结束页码
         */
        this.startIndex = pageNum -2;
        this.endIndex = pageNum +2;
        //判断特殊条件
        if(this.pageNum<=3|this.totalPage==5){
            this.startIndex = 1;
            this.endIndex = 5;
        }
        if (this.totalPage<5){
            this.startIndex = 1;
            this.endIndex = this.totalPage;
        }
        if (this.endIndex>this.totalPage){
            this.endIndex = this.totalPage;
            if(this.pageNum<=3){
                this.startIndex = 1;
            }else if(this.pageNum>=this.pageNum-2){
                this.startIndex = this.totalPage - 4;
            }
        }
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }

    public void setEndIndex(int endIndex) {
        this.endIndex = endIndex;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", totalCount=" + totalCount +
                ", totalPage=" + totalPage +
                ", list=" + list +
                '}';
    }

    /**
     * bootstrap分页条版本
     * @return
     */
    public String getPageStr(){
        StringBuilder sb = new StringBuilder();
        //首页
        if (this.pageNum==1){
            sb.append("<li class=\"disabled\"><a href=\"javascript:stuMgr.getStuList("+pageNum+","+pageSize+")\" aria-label=\"Previous\"><span aria-hidden=\"true\">«</span></a></li>");
        }else{
            sb.append("<li><a href=\"javascript:stuMgr.getStuList("+(pageNum-1)+","+pageSize+")\" aria-label=\"Previous\"><span aria-hidden=\"true\">«</span></a></li>");
        }

        /**
         * 显示页码
         */
        for (int i = startIndex; i <=endIndex; i++) {
            if(i==pageNum){
                sb.append("<li class=\"active\"><a href=\"javascript:stuMgr.getStuList("+i+","+pageSize+")\">"+i+"<span class=\"sr-only\">(current)</span></a></li>");
            }
            if (i!=pageNum){
                sb.append("<li><a href=\"javascript:stuMgr.getStuList("+i+","+pageSize+")\">"+i+"<span class=\"sr-only\">(current)</span></a></li>");
            }
        }
        //下一页
        if(pageNum<totalPage){
            sb.append("<li><a href=\"javascript:stuMgr.getStuList("+(pageNum+1)+","+pageSize+")\" aria-label=\"Previous\"><span aria-hidden=\"true\">»</span></a></li>");
        }else{
            sb.append("<li class=\"disabled\"><a href=\"javascript:stuMgr.getStuList("+pageNum+","+pageSize+")\" aria-label=\"Previous\"><span aria-hidden=\"true\">»</span></a></li>");
        }

        sb.append("<span>当前第"+pageNum+"页,共"+totalPage+"页,共计"+totalCount+"条数据;跳转到<input class='pageNum' type=\"number\" value=\""+pageNum+"\">页<input onclick=\"stuMgr.gotoStuList("+pageSize+")\" type=\"button\" value=\"GO\"/></span>");


        return sb.toString();
    }

    public void setPageStr(String pageStr) {
        this.pageStr = pageStr;
    }
}
