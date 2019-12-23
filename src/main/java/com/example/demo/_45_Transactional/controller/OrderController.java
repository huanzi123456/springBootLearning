package com.example.demo._45_Transactional.controller;

import com.example.demo._45_Transactional.entity.OrderDTO;
import com.example.demo._45_Transactional.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @CliassName: OrderController
 * @Author: DZ5343
 * @Date: 2019/12/23 16:13
 * @Description:
 */
@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    /**
     * {
     *  "orderId": 1,
     *  "items": [
     *                {
     *          "orderId": 1,
     *          "goodsId": 1,
     *          "quantity": 2
     *        }
     *  ]
     * }
     */
    @PostMapping("/")
    public String addShoppingCart(@RequestBody OrderDTO orderDTO) {
        orderService.addShoppingCart(orderDTO);
        return "success";
    }

}
