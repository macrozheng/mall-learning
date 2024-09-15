package com.macro.mall.tiny.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.RandomUtil;
import com.macro.mall.tiny.mbg.mapper.AlipayOrderMapper;
import com.macro.mall.tiny.mbg.model.AlipayOrder;
import com.macro.mall.tiny.mbg.model.AlipayOrderExample;
import com.macro.mall.tiny.service.AlipayOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @auther macrozheng
 * @description 支付宝订单管理Service实现类
 * @date 2023/9/8
 * @github https://github.com/macrozheng
 */
@Service
public class AlipayOrderServiceImpl implements AlipayOrderService {
    @Autowired
    private AlipayOrderMapper alipayOrderMapper;

    @Override
    public AlipayOrder create() {
        String orderId = new SimpleDateFormat("yyyyMMdd").format(new Date()) + System.currentTimeMillis();
        AlipayOrder alipayOrder = new AlipayOrder();
        alipayOrder.setOrderId(orderId);
        //模拟数量
        int quantity = RandomUtil.randomInt(1, 5);
        BigDecimal price = new BigDecimal(20);
        alipayOrder.setSubject("测试商品"+quantity+"个");
        alipayOrder.setTotalAmount(price.multiply(new BigDecimal(quantity)));
        alipayOrderMapper.insert(alipayOrder);
        return alipayOrder;
    }

    @Override
    public AlipayOrder info(String orderId) {
        AlipayOrderExample alipayOrderExample = new AlipayOrderExample();
        alipayOrderExample.createCriteria().andOrderIdEqualTo(orderId);
        List<AlipayOrder> orderList = alipayOrderMapper.selectByExample(alipayOrderExample);
        if(CollUtil.isNotEmpty(orderList)){
            return orderList.get(0);
        }
        return null;
    }
}
