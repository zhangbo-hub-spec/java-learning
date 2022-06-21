package week3.supermarket;

import static week3.supermarket.Category.FOOD;

public class MerchandiseV2 {

    public String name;
    public String id;
    public int count;
    public double soldPrice;
    public double purchasePrice;

    private Category category;

    public MerchandiseV2(String name, String id, int count, double soldPrice, double purchasePrice, Category category) {
        this.name = name;
        this.id = id;
        this.count = count;
        this.soldPrice = soldPrice;
        this.purchasePrice = purchasePrice;
        this.category = category;
        // soldPrice = 9/0;
    }

    public MerchandiseV2(String name, String id, int count, double soldPrice, Category category) {
        // double purPrice = soldPrice * 0.8;
        // this(name, id, count, soldPrice, purchasePrice);
        this(name, id, count, soldPrice, soldPrice * 0.8, category);
        // double purPrice = soldPrice * 0.8;
    }

    public MerchandiseV2() {
        this("无名", "000", 0, 1, 1.1, FOOD);

    }

    public void describe() {
        System.out.println("商品名字叫做" + name + "，id是" + id + "。\n 商品售价是" + soldPrice
                + "。商品进价是" + purchasePrice + "。\n商品库存量是" + count +
                "。销售一个的毛利润是" + (soldPrice - purchasePrice) + "。\n商品类别是" + category);
    }

    public double calculateProfit() {
        double profit = soldPrice - purchasePrice;
//        if(profit <= 0){
//            return 0;
//        }
        return profit;
    }

    public double buy(int count) {
        if (this.count < count) {
            return -1;
        }
        return this.count -= count;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getSoldPrice() {
        return soldPrice;
    }

    public void setSoldPrice(double soldPrice) {
        this.soldPrice = soldPrice;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }
}
