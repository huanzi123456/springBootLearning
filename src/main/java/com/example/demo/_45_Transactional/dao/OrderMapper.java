package com.example.demo._45_Transactional.dao;

import com.example.demo._45_Transactional.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @CliassName: OrderMapper
 * @Author: DZ5343
 * @Date: 2019/12/23 16:16
 * @Description:
 */
@Repository
public interface OrderMapper {
    void updateOrderInfo(@Param("orderId") Long orderId);

    List<Order> getOrders();

}
