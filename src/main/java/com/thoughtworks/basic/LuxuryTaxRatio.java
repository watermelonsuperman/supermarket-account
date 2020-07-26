package com.thoughtworks.basic;

import java.math.BigDecimal;

class LuxuryTaxRatio extends TaxChargeWay {
    private static final BigDecimal LUXURY_TAX_RATIO = BigDecimal.valueOf(0.1);
    private static final int LUXURY_RATIO_MIN_PRICE = 10001;

    @Override
    boolean isInScope(Goods goods) {
        return isLuxury(goods);
    }

    @Override
    BigDecimal getDefaultRatio() {
        return LUXURY_TAX_RATIO;
    }

    private boolean isLuxury(Goods goods) {
        return goods.getPrice() >= LUXURY_RATIO_MIN_PRICE;
    }
}
