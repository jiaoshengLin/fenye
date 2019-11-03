package com.qf.service;

import com.qf.entity.PageBean;
import com.qf.entity.Stu;

/**
 * Stu 业务层接口
 */
public interface StuService {

    /**
     * 获取Stu 对象集合的pageBean分页对象
     */
    public PageBean<Stu> getPageBean(int pageNum, int pageSize);

}
