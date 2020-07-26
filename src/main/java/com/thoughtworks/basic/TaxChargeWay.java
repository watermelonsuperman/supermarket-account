package com.thoughtworks.basic;

import java.math.BigDecimal;

abstract class TaxChargeWay {
    abstract boolean isInScope(Goods goods);
    abstract BigDecimal getDefaultRatio();

    BigDecimal chargeTaxRatio(Goods goods) {
        if (isInScope(goods)) {
            return getDefaultRatio();
        }
        return BigDecimal.ZERO;
    }
}
