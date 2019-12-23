package com.example.demo._45_Transactional.entity;

import lombok.Data;

import java.util.List;

/**
 * @CliassName: OrderDTO
 * @Author: DZ5343
 * @Date: 2019/12/23 16:15
 * @Description:
 */
@Data
public class OrderDTO {
    private Long orderId;
    private List<OrderItem> items;
}
