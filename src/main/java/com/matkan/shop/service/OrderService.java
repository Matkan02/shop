package com.matkan.shop.service;

import com.matkan.shop.Cart;
import com.matkan.shop.dto.OrderDto;
import com.matkan.shop.mapper.OrderMapper;
import com.matkan.shop.model.order.Order;
import com.matkan.shop.repository.order.OrderItemRepository;
import com.matkan.shop.repository.order.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final Cart cart;
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;


    public OrderService(Cart cart, OrderRepository orderRepository, OrderItemRepository orderItemRepository) {
        this.cart = cart;
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
    }

    public void saveOrder(OrderDto orderDto){
        Order order = OrderMapper.mapToOrder(orderDto);
        orderRepository.save(order);
        orderItemRepository.saveAll(OrderMapper.mapToOrderItemList(cart,order));
        cart.cleanCart();
    }
}
