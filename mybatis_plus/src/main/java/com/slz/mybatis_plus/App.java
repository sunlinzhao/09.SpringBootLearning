package com.slz.mybatis_plus;

import com.baomidou.mybatisplus.core.MybatisSqlSessionFactoryBuilder;
import com.slz.mybatis_plus.entity.Team;
import com.slz.mybatis_plus.mapper.TeamMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
//        SqlSession session = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatisConfig.xml")).openSession();
        SqlSession session = new MybatisSqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatisConfig.xml")).openSession();
        TeamMapper mapper = session.getMapper(TeamMapper.class);
        List<Team> teams = mapper.selectList(null);
        teams.forEach(System.out::println);
        session.close();
    }
}
