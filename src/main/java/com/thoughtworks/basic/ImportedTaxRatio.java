package com.thoughtworks.basic;

import java.math.BigDecimal;

public class ImportedTaxRatio implements TaxChargeWay {
    private static final BigDecimal IMPORTED_TAX_RATIO = BigDecimal.valueOf(0.05);

    @Override
    public BigDecimal chargeTaxRatio(Goods goods) {
        if (goods.isImported()) {
            return IMPORTED_TAX_RATIO;
        }
        return BigDecimal.ZERO;
    }
}
