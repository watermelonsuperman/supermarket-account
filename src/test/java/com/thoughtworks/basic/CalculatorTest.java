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
        assertThat(tax, is(BigDecimal.valueOf(100)));
    }

    @Test
    public void should_return_0_when_calculate_given_local_book_and_is_tax_free() {
        //given
        Goods goods = new Goods(GoodsType.BOOK, 50, Origin.LOCAL);
        Calculator calculator = new Calculator();

        //when
        BigDecimal tax = calculator.calculate(goods);

        //then
        assertThat(tax, is(BigDecimal.ZERO));
    }

    @Test
    public void should_return_0_when_calculate_given_local_food_and_is_tax_free() {
        //given
        Goods goods = new Goods(GoodsType.FOOD, 20, Origin.LOCAL);
        Calculator calculator = new Calculator();

        //when
        BigDecimal tax = calculator.calculate(goods);

        //then
        assertThat(tax, is(BigDecimal.ZERO));
    }

    @Test
    public void should_return_0_when_calculate_given_local_medical_and_is_tax_free() {
        //given
        Goods goods = new Goods(GoodsType.MEDICAL, 20, Origin.LOCAL);
        Calculator calculator = new Calculator();

        //when
        BigDecimal tax = calculator.calculate(goods);

        //then
        assertThat(tax, is(BigDecimal.ZERO));
    }
}
