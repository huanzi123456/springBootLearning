package com.example.demo._45_Transactional.service;

import com.example.demo._45_Transactional.Transactional;
import com.example.demo._45_Transactional.entity.Order;
import com.example.demo._45_Transactional.entity.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @CliassName: OrderService
 * @Author: DZ5343
 * @Date: 2019/12/23 16:14
 * @Description:
 */
@Service
public interface OrderService {

    public List<Order> getOrders();


    void addShoppingCart(OrderDTO orderDTO);
}
