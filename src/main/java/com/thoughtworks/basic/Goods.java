package com.thoughtworks.basic;

class Goods {
    private final GoodsType goodsType;
    private final int price;
    private final Origin origin;

    Goods(GoodsType goodsType, int price, Origin origin) {
        this.goodsType = goodsType;
        this.price = price;
        this.origin = origin;
    }

    int getPrice() {
        return price;
    }

    GoodsType getType() {
        return goodsType;
    }
}
