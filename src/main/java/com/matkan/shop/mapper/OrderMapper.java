package com.matkan.shop.mapper;

import com.matkan.shop.CarItem;
import com.matkan.shop.Cart;
import com.matkan.shop.dto.OrderDto;
import com.matkan.shop.model.order.Order;
import com.matkan.shop.model.order.OrderItem;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderMapper {
    public static Order mapToOrder(OrderDto orderDto)
    {
        return  Order.builder()
                .firstName(orderDto.getFirstName())
                .lastName(orderDto.getLastName())
                .address(orderDto.getAddress())
                .postCode(orderDto.getPostCode())
                .city(orderDto.getCity())
                .created(LocalDateTime.now())
                .build();

    }
    public static List<OrderItem> mapToOrderItemList(Cart cart , Order order)
    {
        List<OrderItem> orderItems = new ArrayList<>();
        for (CarItem ci: cart.getCartItems())
        {
            orderItems.add(new OrderItem(order.getOrderId(), ci.getItem().getId(), ci.getCounter()));

        }
return orderItems;
    }
}
