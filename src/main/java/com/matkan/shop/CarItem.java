package com.matkan.shop;

import com.matkan.shop.model.Item;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class CarItem {
    private Item item;
    private int counter;
    private BigDecimal price;

    public CarItem(Item item) {
        this.item = item;
        this.counter = 1;
        this.price = item.getPrice();
    }

    public void increaseCounter()
    {
        counter++;
        price = item.getPrice().multiply(new BigDecimal(counter));
    }

    public void decreaseCounter()
    {
        if (counter > 0)
        {
            counter--;
            price = item.getPrice().multiply(new BigDecimal(counter));
        }
    }

    public boolean hasZeroItem()
    {
        return counter == 0;
    }

    public boolean idEquals(Item item)
    {
        return this.item.getId() == item.getId();
    }
}
