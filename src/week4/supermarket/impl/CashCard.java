package week4.supermarket.impl;

import week4.supermarket.interfaces.Card;
import week4.supermarket.interfaces.Customer;
import week4.supermarket.interfaces.ShoppingCart;

/**
 * 抵扣现金的卡
 */
//
public class CashCard implements Card {

    // 1:1抵扣现金的点数
    private double point;

    public CashCard(double point) {
        this.point = point;
    }

    @Override
    public double processCardDiscount(double totalCost, double totalCostAfterDiscount,
                                      Customer customer, ShoppingCart shoppingCart) {
        // 如果折扣下来剩下的钱比点数少，那么就抵扣掉需要付的剩下的钱
        if (totalCostAfterDiscount < point) {
            point -= totalCostAfterDiscount;
            return totalCostAfterDiscount;
        } else {
            // 否则就抵扣掉所有的点
            point = 0;
            return point;
        }
    }
}
