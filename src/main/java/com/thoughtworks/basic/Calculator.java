package com.thoughtworks.basic;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

class Calculator {
    private static final BigDecimal BASIC_TAX_RATIO = BigDecimal.valueOf(0.1);
    private List<GoodsType> basicTaxFreeGoodsTypes = Arrays.asList(GoodsType.BOOK, GoodsType.FOOD, GoodsType.MEDICAL);

    BigDecimal calculate(Goods goods) {
        if (isBasicTaxFree(goods.getType())) {
            return BigDecimal.ZERO;
        }
        return BASIC_TAX_RATIO.multiply(BigDecimal.valueOf(goods.getPrice())).setScale(0);
    }

    private boolean isBasicTaxFree(GoodsType goodsType) {
        return basicTaxFreeGoodsTypes.contains(goodsType);
    }
}
