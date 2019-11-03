package com.qf.service.impl;

import com.qf.dao.StuDao;
import com.qf.dao.impl.StuDaoImpl;
import com.qf.entity.PageBean;
import com.qf.entity.Stu;
import com.qf.service.StuService;

import java.util.List;

public class StuServiceImpl implements StuService {

    StuDao stuDao = new StuDaoImpl();

    @Override
    public PageBean<Stu> getPageBean(int pageNum, int pageSize) {
        //得到分页的数据集合
        List<Stu> stuList = stuDao.getStusPage(pageNum, pageSize);
        //获取总记录数
        long totalCout = stuDao.getStuCount();
        //组装pageBean对象
        PageBean<Stu> pageBean = new PageBean<Stu>(pageNum, pageSize, (int) totalCout, stuList);
        return pageBean;
    }
}
