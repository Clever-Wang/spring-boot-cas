package com.wangsaichao.cas.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.*;

/**
 * @author: wangsaichao
 * @date: 2018/7/18
 * @description: 查询角色相关信息
 */
@Repository("roleDao")
public class RoleDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    /**
     * 根据用户id查询角色信息
     * @param uid
     * @return
     */
    public String findRolesByUserId(String uid){

        String string = jdbcTemplate.query("SELECT r.role from sys_role r LEFT JOIN sys_user_role ur on r.id = ur.role_id where ur.uid  = ?", new Object[]{uid}, new ResultSetExtractor<String>() {
            @Override
            public String extractData(ResultSet rs) throws SQLException, DataAccessException {
                String string = "";
                //获取键名
                ResultSetMetaData md = rs.getMetaData();
                //获取字段的数量,这里只有一列 role 所以并没有用
                int columnCount = md.getColumnCount();
                while (rs.next()) {
                    //role 是数据库字段, 角色名称
                    string = rs.getString("role");
                }
                return string;
            }
        });
        return string;
    }

    /**
     * 查询所有的角色信息
     * @return
     */
    public Set<String> findAllRoles(){

        Set<String> set = jdbcTemplate.query("SELECT r.role from sys_role r", new ResultSetExtractor<Set<String>>() {
            @Override
            public Set<String> extractData(ResultSet rs) throws SQLException, DataAccessException {
                Set<String> set = new HashSet();
                //获取键名
                ResultSetMetaData md = rs.getMetaData();
                //获取字段的数量,这里只有一列 role 所以并没有用
                int columnCount = md.getColumnCount();
                while (rs.next()) {
                    //role 是数据库字段, 角色名称
                    set.add(rs.getString("role"));
                }
                return set;
            }
        });

        return set;
    }
}
