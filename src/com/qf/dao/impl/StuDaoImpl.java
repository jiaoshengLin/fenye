package com.qf.dao.impl;

import com.qf.dao.StuDao;
import com.qf.entity.Stu;
import com.qf.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Stu Dao层实现类
 */
public class StuDaoImpl implements StuDao {
    @Override
    public List<Stu> getStusPage(int pageNum, int pageSize) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Stu> stuList = new ArrayList<>();
        String sql = "SELECT id,username,card,department FROM  stu LIMIT ?,? ";
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            //设置分页参数
            ps.setInt(1,(pageNum-1)*pageSize);
            ps.setInt(2,pageSize);
            rs = ps.executeQuery();
            Stu stu = null;
            while (rs.next()){
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String card = rs.getString("card");
                String department = rs.getString("department");
                //组装数据到Stu对象
                stu = new Stu(id,username,card,department);
                stuList.add(stu);
            }
            System.out.println("执行语句[ "+sql+" ]成功!");
            return stuList;
        } catch (SQLException e) {
            System.out.println("执行语句[ "+sql+" ]失败!");
            e.printStackTrace();
        }finally {
            DBUtils.close(conn,ps,rs);
        }
        return stuList;
    }

    @Override
    public long getStuCount() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        long totalCount = 0L;
        String sql = " SELECT COUNT(1) FROM  stu ";
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                totalCount = rs.getInt(1);
            }
            System.out.println("执行语句[ "+sql+" ]成功!");
        } catch (Exception e) {
            System.out.println("执行语句[ "+sql+" ]失败!");
            e.printStackTrace();
        }finally {
            DBUtils.close(conn,ps,rs);
        }
        return totalCount;
    }
}
