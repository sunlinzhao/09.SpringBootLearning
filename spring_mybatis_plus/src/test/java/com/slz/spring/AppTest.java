package com.slz.spring;

import com.slz.spring.mapper.TeamMapper;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class AppTest {
    @Resource
    private TeamMapper teamMapper;
    @Test
    public void Test() {
        teamMapper.selectList(null).forEach(System.out::println);
    }
}
