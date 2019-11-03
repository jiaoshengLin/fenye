package com.qf.web.servlet;

import com.alibaba.fastjson.JSON;
import com.qf.entity.PageBean;
import com.qf.entity.Stu;
import com.qf.service.StuService;
import com.qf.service.impl.StuServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/getStuList")
public class PageStuServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //doGet(request,response);
        //设置字符集编码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        //获取前端传入参数
        String num = request.getParameter("pageNum");
        String size = request.getParameter("pageSize");



        //判断参数是否合法
        if (num!=null&&size!=null&&num.length()>0&&size.length()>0){
            int pageNum,pageSize;
            pageNum = Integer.parseInt(num);
            pageSize = Integer.parseInt(size);

            //调用业务层实现分页
            StuService stuService = new StuServiceImpl();
            PageBean<Stu> pageBean = stuService.getPageBean(pageNum,pageSize);
            Map<String ,Object> maps = new HashMap<>();
            List<Stu> stus = pageBean.getList();
            String pageStr = pageBean.getPageStr();
            maps.put("stus",stus);
            maps.put("pageStr",pageStr);
            String json = JSON.toJSONString(maps);
            response.getWriter().write(json);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符集编码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        //获取前端传入参数
        String num = request.getParameter("pageNum");
        String size = request.getParameter("pageSize");



        //判断参数是否合法
        int pageNum,pageSize;
        if (num!=null&&size!=null&&num.length()>0&&size.length()>0){
            pageNum = Integer.parseInt(num);
            pageSize = Integer.parseInt(size);

        }else{
            pageNum = 1;
            pageSize = 3;
        }
        //调用业务层实现分页
        StuService stuService = new StuServiceImpl();
        PageBean<Stu> pageBean = stuService.getPageBean(pageNum,pageSize);
        request.setAttribute("pageBean",pageBean);
        request.getRequestDispatcher("./stu2.jsp").forward(request,response);
    }
}
