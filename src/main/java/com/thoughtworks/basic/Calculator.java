package com.thoughtworks.basic;

import java.math.BigDecimal;
import java.util.List;

class Calculator {
    BigDecimal calculate(Goods goods, List<TaxChargeWay> taxChargeWays) {
        BigDecimal ratio = taxChargeWays.stream()
                .map(taxChargeWay -> taxChargeWay.chargeTaxRatio(goods))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return ratio.multiply(BigDecimal.valueOf(goods.getPrice())).setScale(0);
    }
}
