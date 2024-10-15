package com.slz.springboot.pay;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * @author : SunLZ
 * @project : SpringBootLearning
 * @date : 2024/10/9
 */
@Component
@Profile("prod") // 在生产环境中加载此实现类
public class WcPay implements Pay{
    @Override
    public String pay() {
        return "微信支付";
    }
}
