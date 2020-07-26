package com.thoughtworks.basic;

import java.math.BigDecimal;

class Calculator {
    private static final BigDecimal BASIC_TAX_RATIO = BigDecimal.valueOf(0.1);

    BigDecimal calculate(Goods goods) {
        return BASIC_TAX_RATIO.multiply(BigDecimal.valueOf(goods.getPrice()));
    }
}
