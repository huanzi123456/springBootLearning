package com.example.demo._45_Transactional.service.impl;

import com.example.demo._45_Transactional.dao.OrderItemMapper;
import com.example.demo._45_Transactional.dao.OrderMapper;
import com.example.demo._45_Transactional.entity.OrderDTO;
import com.example.demo._45_Transactional.service.OrderServiceHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @CliassName: OrderServiceHelperImpl
 * @Author: DZ5343
 * @Date: 2019/12/23 16:26
 * @Description:
 */
@Service
public class OrderServiceHelperImpl implements OrderServiceHelper {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderItemMapper orderItemMapper;

    /**
     * REQUIRES_NEW: 重新创建一个新的事务，如果当前存在事务，暂停当前的事务
     * 自己独立一个事务，不受其它事务干扰
     * 注意：test方法要放到其它service中，不能放在OrderServiceImpl中
     */
    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public void test(OrderDTO orderDTO){
        Long orderId = orderDTO.getOrderId();
        orderMapper.updateOrderInfo(orderId);
        orderItemMapper.insertOrderItems(orderId, orderDTO.getItems());
    }

}
