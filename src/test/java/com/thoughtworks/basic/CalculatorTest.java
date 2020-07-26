package com.thoughtworks.basic;

import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {
    @Test
    public void should_return_basic_tax_when_calculate_given_local_goods_and_not_tax_free() {
        //given
        Goods goods = new Goods(GoodsType.ELECTRONIC, 1000, Origin.LOCAL);
        Calculator calculator = new Calculator();

        //when
        BigDecimal tax = calculator.calculate(goods);

        //then
        assertThat(tax.setScale(0), is(BigDecimal.valueOf(100)));
    }
}
