package com.thoughtworks.basic;

import java.math.BigDecimal;

public class LuxuryTaxRatio implements TaxChargeWay {
    private static final BigDecimal LUXURY_TAX_RATIO = BigDecimal.valueOf(0.1);
    private static final int LUXURY_RATIO_MIN_PRICE = 10001;

    @Override
    public BigDecimal chargeTaxRatio(Goods goods) {
        if (isLuxury(goods)) {
            return LUXURY_TAX_RATIO;
        }
        return BigDecimal.ZERO;
    }

    private boolean isLuxury(Goods goods) {
        return goods.getPrice() >= LUXURY_RATIO_MIN_PRICE;
    }
}
