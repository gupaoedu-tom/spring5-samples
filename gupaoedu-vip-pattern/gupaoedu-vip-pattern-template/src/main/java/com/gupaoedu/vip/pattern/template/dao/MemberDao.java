package com.gupaoedu.vip.pattern.template.dao;

import com.gupaoedu.vip.pattern.template.JdbcTemplate;
import com.gupaoedu.vip.pattern.template.RowMapper;
import com.gupaoedu.vip.pattern.template.entity.Member;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.List;

/**
 * Created by Tom
 */
public class MemberDao extends JdbcTemplate {

    public MemberDao(DataSource dataSource) {
        super(dataSource);
    }

    public List<?> query(){
        String sql = "select * from t_member";
        return super.executeQuery(sql,new RowMapper<Member>(){
            public Member mapRow(ResultSet rs, int rowNum) throws Exception {
                Member member = new Member();
                member.setUsername(rs.getString("username"));
                member.setPassword(rs.getString("password"));
                member.setAge(rs.getInt("age"));
                member.setAddr(rs.getString("addr"));
                return member;
            }
        },null);
    }

}
