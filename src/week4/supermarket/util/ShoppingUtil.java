package week4.supermarket.util;

import week4.supermarket.impl.*;
import week4.supermarket.interfaces.Category;
import week4.supermarket.interfaces.Customer;
import week4.supermarket.interfaces.Merchandise;
import week4.supermarket.interfaces.SuperMarket;

import java.util.Scanner;

public class ShoppingUtil {

    private static final Scanner in = new Scanner(System.in);

    public static Scanner input() {
        return in;
    }

    public static void output(Object obj) {
        System.out.println(String.valueOf(obj));
    }


    public static SuperMarket createSuperMarket() {
        int merchandisePerCategory = 10;
        Merchandise[] all = new Merchandise[Category.values().length * merchandisePerCategory];

        for (Category category : Category.values()) {
            for (int i = 0; i < merchandisePerCategory; i++) {

                double soldPrice = Double.parseDouble(new java.text.DecimalFormat("#.00").format(Math.random() * (category.getHigherPrice() - category.getLowerPrice())
                        + category.getLowerPrice()));

                double purchasePrice = Double.parseDouble(new java.text.DecimalFormat("#.00").format(soldPrice * 0.7));

                all[category.ordinal() * merchandisePerCategory + i] = new SimpleMerchandise(
                    category.name() + i, soldPrice, purchasePrice, 200, category
                );
            }
        }

        SimpleSuperMarket superMarket = new SimpleSuperMarket(all);
        output("请输入超市的名字：");
        String s = input().next();
        if (s.trim().length() > 0) {
            superMarket.setName(s.trim());
        }
        return superMarket;
    }

    public static Customer createCustomer(boolean auto) {
        if (auto) {
            String custId = "CUST" + (int) (Math.random() * 10000);
            Category shouldBuy = getRandomCategory();
            if (Math.random() < 0.5) {
                return new SuiYuanCustomer(custId, shouldBuy);
            } else {
                ThinkAndBuyCustomer ret = new ThinkAndBuyCustomer(custId, shouldBuy);
                ret.setCard(getRandomVIPCard());
                return ret;
            }
        }

        return null;

    }

    public static Category getRandomCategory() {
        return Category.values()[(int) (Math.random() * 1000) % Category.values().length];
    }

    public static VIPCard getRandomVIPCard() {
        return VIPCard.values()[(int) (Math.random() * 1000) % VIPCard.values().length];
    }


}
