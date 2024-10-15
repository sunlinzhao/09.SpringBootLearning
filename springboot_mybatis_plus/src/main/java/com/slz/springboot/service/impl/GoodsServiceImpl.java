package com.slz.springboot.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.slz.springboot.entity.Goods;
import com.slz.springboot.mapper.GoodsMapper;
import com.slz.springboot.service.GoodsService;
import org.springframework.stereotype.Service;

/**
 * @author : SunLZ
 * @project : SpringBootLearning
 * @date : 2024/10/14
 */
@Service
@DS("master")
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {
}
