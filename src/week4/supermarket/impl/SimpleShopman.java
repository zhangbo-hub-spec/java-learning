package week4.supermarket.impl;

import week4.supermarket.interfaces.*;

import static week4.supermarket.util.ShoppingUtil.output;

public class SimpleShopman implements Shopman {

    private SuperMarket superMarket;

    public SimpleShopman(SuperMarket superMarket) {
        this.superMarket = superMarket;
    }

    private static final int MAX_BUY_DEFAULT = 9;

    @Override
    public void serveCustomer(Customer customer) {
        int maxTypeToBuy = MAX_BUY_DEFAULT;
        if (customer instanceof AbsCustomer) {
            maxTypeToBuy = ((AbsCustomer) customer).getGuangCount();
        }
        ShoppingCart shoppingCart = new ShoppingCart(maxTypeToBuy);
        customer.startShopping();

        while ((!customer.wantToCheckout()) && shoppingCart.canHold()) {
            Category category = customer.chooseCategory();
            // 简单的导购员，顾客说不想买就算了，不做推荐
            if (category == null) {
                continue;
            }
            Merchandise[] toChoose = superMarket.getRandomMerchandiseOfCategory(category);
            // 简单的导购员，一个个推荐，不说从价格高到低推荐之类的小技巧。
            for (Merchandise m : toChoose) {
                if (m == null) {
                    continue;
                }
                int buyCount = customer.buyMerchandise(m);
                if (buyCount > 0) {
                    // 一个类别只买一个商品
                    shoppingCart.add(m, buyCount);
                    break;
                }
            }
        }

        double originCost = shoppingCart.calculateOriginCost();
        double finalCost = originCost;

        double savedMoney = 0;
        if (customer instanceof HasCard) {
            Card card = ((HasCard) customer).getCard();
            savedMoney = Double.parseDouble(new java.text.DecimalFormat("#.00").format(card.processCardDiscount(originCost, finalCost, customer, shoppingCart)));
            finalCost -= Double.parseDouble(new java.text.DecimalFormat("#.00").format(savedMoney));
        }

        double moneyEarned = customer.payFor(shoppingCart, finalCost);

        superMarket.addEarnedMoney(moneyEarned);

        output("顾客" + customer.getCustId() + "购物清单如下：");
        output(shoppingCart.toString());
        output("优惠金额为：" + savedMoney);
        output("实付金额为：" + moneyEarned);


        // >> TODO 思考题：上面的代码是否太过复杂了？如果有别的类型的shopmain，是否有代码可以重用？有的话应该怎么办？

    }


}
