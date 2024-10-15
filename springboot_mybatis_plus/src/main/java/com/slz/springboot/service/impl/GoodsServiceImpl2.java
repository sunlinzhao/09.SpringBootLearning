package com.slz.springboot.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.slz.springboot.entity.Goods;
import com.slz.springboot.mapper.GoodsMapper;
import com.slz.springboot.service.GoodsService;
import com.slz.springboot.service.GoodsService2;
import org.springframework.stereotype.Service;

/**
 * @author : SunLZ
 * @project : SpringBootLearning
 * @date : 2024/10/14
 */
@Service
@DS("slave")
public class GoodsServiceImpl2 extends ServiceImpl<GoodsMapper, Goods> implements GoodsService2 {
}
