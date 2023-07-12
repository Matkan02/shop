package com.matkan.shop.repository.order;

import com.matkan.shop.model.order.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem ,Long> {
}
