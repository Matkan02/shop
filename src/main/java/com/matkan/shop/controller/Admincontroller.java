package com.matkan.shop.controller;

import com.matkan.shop.model.Item;
import com.matkan.shop.model.order.Order;
import com.matkan.shop.repository.ItemRepository;
import com.matkan.shop.repository.order.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class Admincontroller {
    private final ItemRepository itemRepository;
    private final OrderRepository orderRepository;

    @Autowired
    public Admincontroller(ItemRepository itemRepository, OrderRepository orderRepository) {
        this.itemRepository = itemRepository;
        this.orderRepository = orderRepository;
    }
    @GetMapping
    private String adminPage()
    {
        return "viewadditem/additem";
    }


    @PostMapping
    private String additem (Item item)
    {
       itemRepository.save(item);
       return "redirect:/";
    }

    @GetMapping("/showorders")
    @ResponseBody
    public List<Order> showOrders()
    {
        return orderRepository.findAll();
    }

}
