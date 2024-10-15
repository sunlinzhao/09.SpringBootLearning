package com.slz.springboot.pay;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * @author : SunLZ
 * @project : SpringBootLearning
 * @date : 2024/10/9
 */
@Component
@Profile("dev") // 在开发环境中加载此实现类
public class AliPay implements Pay{
    @Override
    public String pay() {
        return "支付宝支付";
    }
}
