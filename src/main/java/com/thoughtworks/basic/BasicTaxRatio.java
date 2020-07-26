package com.thoughtworks.basic;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

class BasicTaxRatio extends TaxChargeWay {
    private static final BigDecimal BASIC_TAX_RATIO = BigDecimal.valueOf(0.1);
    private List<GoodsType> basicTaxFreeGoodsTypes = Arrays.asList(GoodsType.BOOK, GoodsType.FOOD, GoodsType.MEDICAL);

    @Override
    boolean isInScope(Goods goods) {
        return !isBasicTaxFree(goods.getType());
    }

    @Override
    BigDecimal getDefaultRatio() {
        return BASIC_TAX_RATIO;
    }

    private boolean isBasicTaxFree(GoodsType goodsType) {
        return basicTaxFreeGoodsTypes.contains(goodsType);
    }
}
