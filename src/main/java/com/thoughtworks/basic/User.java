package com.thoughtworks.basic;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class User {
    int points;
    public User(){

    }


    public int buyCommonGoods(Goods goods) {
        return goods.price.intValue();
    }

    public int buyPromotionGoods(List<Goods> goodsList) {
        int points = 0;
        for (Goods goods : goodsList){
            if(goods.isPromotionGoods){
                points += goods.price.intValue() * 2 ;
            }else{
                points += goods.price.intValue();
            }
        }
        return points;
    }

    public int buyCommonGoodsOverThousand(List<Goods> goodsList){
        int points = 0;
        int priceSum = sumPrice(goodsList).intValue();
        points = 1000 + (priceSum-1000)/20;
        return points;
    }

    public BigDecimal sumPrice(List<Goods> goodsList){
        int priceSum = 0;
        for (Goods goods : goodsList){
            priceSum += goods.price.intValue();
        }
        BigDecimal sumPrice = new BigDecimal(priceSum);
        return  sumPrice;
    }

    public int buyPromotionGoodsOverThousand(List<Goods> goodsList){

        int points = 0;
        int priceSum = sumPrice(goodsList).intValue();
        points = 1000 * 2 + (priceSum-1000);
        return points;
    }

    public int buyAllKindsOfGoods(List<Goods> goodsList){
        int points = 0;
        List<Goods> promotionGoodsList = new ArrayList<>();
        List<Goods> commonGoodsList = new ArrayList<>();
        for(Goods goods : goodsList){
            if(goods.isPromotionGoods){
                promotionGoodsList.add(goods);
            }else{
                commonGoodsList.add(goods);
            }
        }
        int promotionSumPrice = sumPrice(promotionGoodsList).intValue();
        int commonSumPrice = sumPrice(commonGoodsList).intValue();

        if(promotionSumPrice > 1000){
            points = 1000 * 2 + (promotionSumPrice-1000) + commonSumPrice/20;
        }else{
            int gap = 1000 - promotionSumPrice;
            points = promotionSumPrice * 2 + gap + (commonSumPrice-gap)/20;
        }
        return points;
    }




}
