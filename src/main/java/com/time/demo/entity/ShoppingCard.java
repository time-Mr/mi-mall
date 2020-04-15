package com.time.demo.entity;

import lombok.Data;

/**
 * 购物车
 *
 * @author time
 */
@Data
public class ShoppingCard {

    public Integer shoppingCartId;

    public Integer quantity;

    public String color;

    public String name;

    public String picture1;

    public String productName;

    public Double currentPrice;

    public String conf;

    public String version;

}
