package com.thoughtworks.basic;

import java.math.BigDecimal;

public class Goods {
    GoodsName goodsName;
    BigDecimal price;
    Boolean isPromotionGoods;

    public BigDecimal getPrice() {
        return price;
    }

    public Goods(BigDecimal price) {
        this.price = price;
    }
    public Goods(GoodsName goodsName, BigDecimal price) {
        this.goodsName = goodsName;
        this.price = price;
    }
    public Goods(GoodsName goodsName,BigDecimal price,Boolean isPromotionGoods){
        this.goodsName = goodsName;
        this.price = price;
        this.isPromotionGoods = isPromotionGoods;
    }
}
