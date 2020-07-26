package com.thoughtworks.basic;

import java.math.BigDecimal;

class ImportedTaxRatio extends TaxChargeWay {
    private static final BigDecimal IMPORTED_TAX_RATIO = BigDecimal.valueOf(0.05);

    @Override
    boolean isInScope(Goods goods) {
        return goods.isImported();
    }

    @Override
    BigDecimal getDefaultRatio() {
        return IMPORTED_TAX_RATIO;
    }
}
