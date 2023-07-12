package com.matkan.shop;

import com.matkan.shop.model.Item;
import lombok.Getter;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Getter
public class Cart {
    private List<CarItem> cartItems = new ArrayList<>();
    private int counter = 0;
    private BigDecimal sum = BigDecimal.ZERO;

    public void addItem(Item item)
    {
        getCartItemByItem(item).ifPresentOrElse(
                CarItem::increaseCounter,
                () -> cartItems.add(new CarItem(item))
        );
        calculatePriceAndCounter();
    }

    public void decreaseItem(Item item)
    {
        Optional<CarItem> oCartItem = getCartItemByItem(item);
        if (oCartItem.isPresent()){
            CarItem carItem =  oCartItem.get();
            carItem.decreaseCounter();
            if (carItem.hasZeroItem()){
                removeAllItems(item);
            }else
            {
                calculatePriceAndCounter();
            }
        }

    }

    public void removeAllItems(Item item)
    {
        cartItems.removeIf(i-> i.idEquals(item));
        calculatePriceAndCounter();
    }

    private void calculatePriceAndCounter()
    {
        sum = cartItems.stream().map(CarItem::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        counter = cartItems.stream().mapToInt(CarItem::getCounter)
                .reduce(0, Integer::sum);

    }

    private Optional<CarItem> getCartItemByItem(Item item)
    {return cartItems.stream()
            .filter(i->i.idEquals(item))
            .findFirst();

    }

    public void cleanCart()
    {
        cartItems.clear();
        counter = 0;
        sum = BigDecimal.ZERO;
    }



}
