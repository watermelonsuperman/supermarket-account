package com.thoughtworks.basic;

import java.math.BigDecimal;

public interface TaxChargeWay {
    BigDecimal chargeTaxRatio(Goods goods);
}
