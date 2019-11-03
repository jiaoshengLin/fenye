package com.qf.dao;

import com.qf.entity.Stu;

import java.util.List;

/**
 * Stu Dao层接口
 */
public interface StuDao {

    /**
     * 分页查询Stu 对象集合
     */
    public List<Stu> getStusPage(int pageNum,int pageSize);

    /**
     * 查询所有stu 对象集合
     */
     public long getStuCount();
}
