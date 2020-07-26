package com.thoughtworks.basic;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

class Calculator {
    private static final BigDecimal BASIC_TAX_RATIO = BigDecimal.valueOf(0.1);
    private static final BigDecimal IMPORTED_TAX_RATIO = BigDecimal.valueOf(0.05);
    private List<GoodsType> basicTaxFreeGoodsTypes = Arrays.asList(GoodsType.BOOK, GoodsType.FOOD, GoodsType.MEDICAL);

    BigDecimal calculate(Goods goods) {
        BigDecimal ratio = BigDecimal.ZERO;

        if (!isBasicTaxFree(goods.getType())) {
            ratio = BASIC_TAX_RATIO;
        }

        if (goods.isImported()) {
            ratio = ratio.add(IMPORTED_TAX_RATIO);
        }

        return ratio.multiply(BigDecimal.valueOf(goods.getPrice())).setScale(0);
    }

    private boolean isBasicTaxFree(GoodsType goodsType) {
        return basicTaxFreeGoodsTypes.contains(goodsType);
    }
}
