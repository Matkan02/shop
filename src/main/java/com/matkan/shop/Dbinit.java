package com.matkan.shop;

import com.matkan.shop.model.Item;
import com.matkan.shop.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.List;

@Configuration
public class Dbinit implements CommandLineRunner {


    private ItemRepository itemRepository;

    @Autowired
    public Dbinit(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        itemRepository.saveAll(List.of(

        new Item("Yeezy Boost 350 v2", new BigDecimal("500"), "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT2drlVuqRsGMVfF4O2RXWRkxIvf8UlQhHEDi95WCIvBoUe7348L2BeJfoPhni9nen4Av8&usqp=CAU"),
        new Item("Yeezy Slide", new BigDecimal("1500"), "https://kuzkicks.com/wp-content/uploads/2022/06/Adidas-Yeezy-Slide-Pure.jpg")

        ));
    }
}
