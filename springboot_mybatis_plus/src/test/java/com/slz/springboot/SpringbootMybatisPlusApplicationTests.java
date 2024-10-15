package com.slz.springboot;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mysql.cj.util.StringUtils;
import com.slz.springboot.entity.Goods;
import com.slz.springboot.entity.Team;
import com.slz.springboot.entity.User;
import com.slz.springboot.entity.XueHuaId;
import com.slz.springboot.enums.GoodsStatusEnum;
import com.slz.springboot.mapper.GoodsMapper;
import com.slz.springboot.mapper.TeamMapper;
import com.slz.springboot.mapper.UserMapper;
import com.slz.springboot.mapper.XueHuaIdMapper;
import com.slz.springboot.service.GoodsService;
import com.slz.springboot.service.GoodsService2;
import com.slz.springboot.service.UserService;
import com.slz.springboot.service.impl.GoodsServiceImpl;
import com.slz.springboot.service.impl.GoodsServiceImpl2;
import com.slz.springboot.service.impl.UserServiceImpl;
import lombok.Data;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.sql.Wrapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class SpringbootMybatisPlusApplicationTests {
    @Resource
    private TeamMapper teamMapper;
    @Resource
    private XueHuaIdMapper xueHuaIdMapper;
    @Resource
    private GoodsMapper goodsMapper;
    @Resource
    private GoodsService goodsService;
    @Resource
    private GoodsService2 goodsService2;
    @Resource
    private UserService userService;

    @Test
    void testAc() {
        User user = new User();
        user.setName("刘大鹅");
        user.setAge(54);
        user.setId(1845803772668907522L);
//        boolean insert = user.insert();
        User user1 = user.selectById();
        user1.updateById();
    }

//    @Test
//    void testOpLock(){
//        // @Version 版本号自增前提，更新前做一次查询获得当前版本号
//        User user = userService.getById(1845755094390317057L);
//        // 设置更新数据
//        user.setName("张弘毅");
//        user.setAge(35);
//        // 执行更新操作，user 会带上当前版本号，mybatis-plus 会让版本号加一
//        userService.updateById(user);
//    }

//    @Test
//    void insert() {
//        Goods goods = new Goods();
//        goods.setStatus(GoodsStatusEnum.IN);
//        goods.setName("苹果手机");
//        goods.setPrice(9997.89);
//        goodsService2.save(goods);
//    }

//    @Test
//    void multiDataSource(){
//        goodsService.list().forEach(System.out::println);
//        goodsService2.list().forEach(System.out::println);
//    }

//    @Test
//    void testService(){
//        List<Goods> list = goodsService.list();
//        list.forEach(System.out::println);
//    }
//    @Test
//    void contextLoads() {
//        Goods goods = new Goods();
//        goods.setName("华为手机");
//        goods.setPrice(5055.78);
//        goodsMapper.insert(goods);
//    }
//    @Test
//    void contextLoads() {
//        Goods goods = new Goods();
//        goods.setName("三星手机");
//        goods.setPrice(5543.23);
//        goods.setStatus(GoodsStatusEnum.OUT);
//        goodsMapper.insert(goods);
//        QueryWrapper<Goods> wrapper = new QueryWrapper<>();
//        wrapper.like("name", "华为");
//        goodsMapper.selectList(wrapper).forEach(System.out::println);
//    }
//    @Test
//    void contextLoads() {
//        UpdateWrapper<Goods> wrapper = new UpdateWrapper<>();
//        wrapper.set("name", "魅族手机").eq("id", "1844714135451881474");
//        goodsMapper.update(null, wrapper);
//    }
//    @Test
//    void contextLoads() {
//        xueHuaIdMapper.insert(new XueHuaId());
//    }
//    @Test
//    void contextLoads() {
////        int res = teamMapper.insert(new Team(null, "汪汪",0));
////        teamMapper.selectList(null).forEach(System.out::println);
////        teamMapper.deleteById(230789125);
////        teamMapper.selectList(null).forEach(System.out::println);
//        Map<String, Object> map = new HashMap<>();
//        map.put("id", 1);
//        teamMapper.deleteByMap(map);
//    }
//    @Test
//    void testSelect() {
//        Team team = new Team();
//        team.setId(1);
//        QueryWrapper<Team> wrapper = new QueryWrapper<>(team);
//        teamMapper.selectList(wrapper).forEach(System.out::println);
//    }
//    @Test
//    void testQueryWrapper() {
//        QueryWrapper<Team> wrapper = new QueryWrapper<>();
//        wrapper.like("name", "张")
//                .eq("id", 8);
//        teamMapper.selectList(wrapper).forEach(System.out::println);
//    }
//    @Test
//    void testSelect() {
//        LambdaQueryWrapper<Team> wrapper = new LambdaQueryWrapper<>();
//        wrapper.like(Team::getName, "张");
//        teamMapper.selectList(wrapper).forEach(System.out::println);
//    }
//    @Test
//    void testQueryWrapper() {
//        QueryWrapper<Team> wrapper = new QueryWrapper<>();
//        Team team = new Team();
//        team.setName("勇");
//        wrapper.like(!StringUtils.isNullOrEmpty(team.getName()), "name", team.getName());
//        teamMapper.selectList(wrapper).forEach(System.out::println);
//    }
//    @Test
//    void testUpdate() {
//        Team team = new Team();
//        team.setId(8);
//        team.setName("张fei");
//        teamMapper.updateById(team);
//    }
//    @Test
//    void testUpdate() {
//        UpdateWrapper<Team> wrapper = new UpdateWrapper<>();
//        Team team = new Team();
//        team.setName("汪汪");
//        wrapper.like("name", "张");
//        // 将带张字的队名改为汪汪
//        teamMapper.update(team, wrapper);
//    }
//    @Test
//    void testUpdate() {
//        UpdateWrapper<Team> wrapper = new UpdateWrapper<>();
//        wrapper.like("name", "汪").set("name", "kkk");
//        teamMapper.update(null, wrapper);
//    }
//    @Test
//    void testUpdate() {
//        LambdaUpdateWrapper<Team> wrapper = new LambdaUpdateWrapper<>();
//        wrapper.like(Team::getName, "k").set(Team::getName, "勇士");
//        teamMapper.update(null, wrapper);
//    }
//    @Test
//    void testSelect() {
//        Page<Team> page = new Page<>(2, 3);
//        QueryWrapper<Team> wrapper = new QueryWrapper<>();
//        wrapper.like("name", "勇");
//        // 获取查询结果
//        teamMapper.selectPage(page, wrapper).getRecords().forEach(System.out::println);
//        System.out.println("总记录数：" + page.getTotal() + "，总页数：" + page.getPages() +
//                "，是否有上一页" + page.hasPrevious());
//    }
//    @Test
//    void testCustom() {
//        Page<Team> page = new Page<>(2, 3);
//        teamMapper.selectCustomPage(page, "勇");
//        page.getRecords().forEach(System.out::println);
//        System.out.println("总记录数：" + page.getTotal() + "，总页数：" + page.getPages());
//        teamMapper.selectCustom().forEach(System.out::println);
//    }

}
