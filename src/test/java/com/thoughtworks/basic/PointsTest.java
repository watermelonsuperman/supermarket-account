package com.thoughtworks.basic;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.thoughtworks.basic.GoodsName.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class PointsTest {

    //需求一 用户购买了100元的商品，则获得100个积分。 用户购买了110元的商品，则获得110个积分
    @Test
    public void should_return_100_points_when_buy_common_goods_give_100(){
        //given
        User user = new User();
        Goods goods = new Goods(new BigDecimal(100));
        //when
        int points = user.buyCommonGoods(goods);
        //then
        assertThat(100,is(user.buyCommonGoods(goods)));
    }
    //需求二
    //当用户购买的商品，属于促销商品时，其获得的积分加倍
    //超市促销苹果、西瓜、牛肉，当用户购买了以下商品：
    //苹果 10元
    //西瓜 30元
    //洗衣液 20元 则本次购物，用户可获取100积分。
    @Test
    public void should_return_100_points_when_buy_promotion_goods_when_give_account_goods(){
        //given
        User user = new User();
        Goods watermelon = new Goods(WATERMELON,new BigDecimal(30),true);
        Goods apple = new Goods(APPLE,new BigDecimal(10),true);
        Goods laundry = new Goods(LAUNDRY,new BigDecimal(20),false);
        List<Goods> goodsList = new ArrayList<>();
        goodsList.add(watermelon);
        goodsList.add(apple);
        goodsList.add(laundry);
        //when
        int points = user.buyPromotionGoods(goodsList);
        //then
        assertThat(100,is(points));

    }

    //需求三 (附加题)
    //step1
    //当用户购买的商品超过1000元时，积分的计算规则变更为每20元一个积分。
    //例如： 用户购买了一台价值2350元的冰箱，则用户可获得 1000 + 1350/20 = 1067个积分
    @Test
    public void should_return_1067_points_when_buy_common_goods_over_1000_give_2350(){
        //given
        User user = new User();
        Goods goods = new Goods(REFRIGERATOR,new BigDecimal(2350));
        //when
        List<Goods> goodsList = new ArrayList<>();
        goodsList.add(goods);
        int points = user.buyCommonGoodsOverThousand(goodsList);
        //then
        assertThat(1067,is(points));
    }
    //step2
    //当用户购买的商品是促销商品且总价值超过了1000元时，积分不再加倍，仍然是1元对应1个积分。
    //例如：
    //超市促销电视机、冰箱，当用户购买了以下商品：
    //电视机 2000元 则本次购物，用户可获取 1000 * 2 + 1000 = 3000积分。
    @Test
    public void should_return_3000_points_when_buy_production_goods_over_1000_give_2000(){
        //given
        User user = new User();
        Goods goods = new Goods(TELEVISION,new BigDecimal(2000));
        //when
        List<Goods> goodsList = new ArrayList<>();
        goodsList.add(goods);
        int points = user.buyPromotionGoodsOverThousand(goodsList);
        //then
        assertThat(3000,is(points));
    }
    //step3
    //当用户同时购买了促销商品和非促销商品，且总价超过了1000元时，为了让用户可以获得更多积分，尽可能的优先使促销商品积分加倍。
    //例如：
    //超市促销电视机、冰箱，当用户购买了以下商品时：
    //电视机800元
    //洗衣机2000元 则本次购物，用户可获得 800 * 2 + 200 + 1800/20 = 1890积分
    @Test
    public void should_return_1890_points_when_buy_all_kind_goods_over_1000_give_2000_and_800(){
        //given
        User user = new User();
        Goods television = new Goods(TELEVISION,new BigDecimal(800),true);
        Goods refrigerator = new Goods(REFRIGERATOR,new BigDecimal(2000),false);
        List<Goods> goodsList = new ArrayList<>();
        goodsList.add(television);
        goodsList.add(refrigerator);
        //when
        int points = user.buyAllKindsOfGoods(goodsList);
        //then
        assertThat(1890,is(points));
    }

}
