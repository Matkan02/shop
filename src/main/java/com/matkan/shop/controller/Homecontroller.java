package com.matkan.shop.controller;


import com.matkan.shop.ItemOperation;
import com.matkan.shop.model.Item;
import com.matkan.shop.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class Homecontroller {

private final CartService cartService;

    @Autowired
    public Homecontroller(CartService cartService) {
        this.cartService = cartService;
    }


    @GetMapping("/")
    public String home(Model model)
    {
        model.addAttribute("items", cartService.getallitems());
        return "home";

    }

    @GetMapping("/add/{itemId}")
    public String addcart(@PathVariable("itemId") Long itemId , Model model )
    {
        cartService.itemOperation(itemId, ItemOperation.INCREASE);
        model.addAttribute("items", cartService.getallitems());
        return "home";
    }
}
