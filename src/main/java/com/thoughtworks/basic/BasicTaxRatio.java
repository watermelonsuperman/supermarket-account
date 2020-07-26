package com.thoughtworks.basic;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class BasicTaxRatio implements TaxChargeWay {
    private static final BigDecimal BASIC_TAX_RATIO = BigDecimal.valueOf(0.1);
    private List<GoodsType> basicTaxFreeGoodsTypes = Arrays.asList(GoodsType.BOOK, GoodsType.FOOD, GoodsType.MEDICAL);

    @Override
    public BigDecimal chargeTaxRatio(Goods goods) {
        if (!isBasicTaxFree(goods.getType())) {
            return BASIC_TAX_RATIO;
        }
        return BigDecimal.ZERO;
    }

    private boolean isBasicTaxFree(GoodsType goodsType) {
        return basicTaxFreeGoodsTypes.contains(goodsType);
    }
}
