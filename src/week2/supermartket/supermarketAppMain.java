package week2.supermartket;

import supermartket.parameter.Merchandise;
import supermartket.parameter.Supermarket;


public class supermarketAppMain {
    public static void main(String[] args) {
        // 创建一个小超市类
        Supermarket Supermarket = new Supermarket(
                "bony supermarket", "新北区万达",
                200, 100, 200);
        Merchandise Merchandise = new Merchandise();
//
        System.out.println("利润最高的商品为");
        Supermarket.getBiggestProfitMerchandise().describe();
        Merchandise.describe();
    }
}