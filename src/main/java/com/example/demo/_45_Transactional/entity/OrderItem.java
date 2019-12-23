package com.example.demo._45_Transactional.entity;

import lombok.Data;

/**
 * @CliassName: OrderItem
 * @Author: DZ5343
 * @Date: 2019/12/23 16:15
 * @Description:
 */
@Data
public class OrderItem {
    private Long orderId;
    private Long goodsId;
    private Long quantity;
}
