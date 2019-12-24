package com.example.demo._45_Transactional.dao;

import com.example.demo._45_Transactional.entity.OrderItem;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List; /**
 * @CliassName: OrderItemMapper
 * @Author: DZ5343
 * @Date: 2019/12/23 16:33
 * @Description:
 */
@Repository
public interface OrderItemMapper {
    void insertOrderItems(Long orderId, List<OrderItem> items);

}
