package com.example.demo._45_Transactional.service.impl;

import com.example.demo._45_Transactional.Transactional;
import com.example.demo._45_Transactional.dao.OrderItemMapper;
import com.example.demo._45_Transactional.dao.OrderMapper;
import com.example.demo._45_Transactional.entity.Order;
import com.example.demo._45_Transactional.entity.OrderDTO;
import com.example.demo._45_Transactional.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @CliassName: OrderServiceImpl
 * @Author: DZ5343
 * @Date: 2019/12/23 16:25
 * @Description:
 */
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    private OrderItemMapper orderItemMapper;

    @Override
    @Transactional(readOnly = true)
    public List<Order> getOrders() {
        return orderMapper.getOrders();
    }

    //添加到购物车
    @Override
//    @Transactional(rollbackFor = Exception.class)  //1

    public void addShoppingCart(OrderDTO orderDTO) {
        /*Long orderId = orderDTO.getOrderId();
        orderMapper.updateOrderInfo(orderId);
        orderItemMapper.insertOrderItems(orderId, orderDTO.getItems());
        // 测试事务(当发生Exception时，回滚事务)
        int error = 1/0;*/    //1
        test(orderDTO);
    }

    private void test(OrderDTO orderDTO) {

    }


    @Transactional(rollbackFor = Exception.class)
    public void doAddShoppingCart(OrderDTO orderDTO){
        Long orderId = orderDTO.getOrderId();
        orderMapper.updateOrderInfo(orderId);
        orderItemMapper.insertOrderItems(orderId, orderDTO.getItems());
        int error = 1/0;
    }

}
