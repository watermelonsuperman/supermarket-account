package com.thoughtworks.basic;

import java.math.BigDecimal;

class Goods {
    private final GoodsType goodsType;
    private final int price;
    private final Origin local;

    Goods(GoodsType goodsType, int price, Origin local) {
        this.goodsType = goodsType;
        this.price = price;
        this.local = local;
    }

    int getPrice() {
        return price;
    }
}
