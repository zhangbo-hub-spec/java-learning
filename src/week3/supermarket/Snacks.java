package week3.supermarket;

import java.util.Date;

public class Snacks extends MerchandiseV2 implements ExpireDateMerchandise {
    private Date produceDate;
    private Date expirationDate;

    private String Manufacturer;

    private String RawMaterial;

    public Snacks(String name, String id, int count, double soldPrice, double purchasePrice, Category category,
                  String Manufacturer, String RawMaterial, Date produceDate, Date expirationDate) {
        super(name, id, count, soldPrice, purchasePrice, category);
        this.Manufacturer = Manufacturer;
        this.RawMaterial = RawMaterial;
        this.produceDate = produceDate;
        this.expirationDate = expirationDate;

    }

    public void describeSnacks() {
        System.out.println("此显卡商品属性如下");
        System.out.println("生产厂家为" + Manufacturer + "\n" +
                "产品原料:" + RawMaterial + "\n");
    }

    @Override
    public Date getProducedDate() {
        return produceDate;
    }

    @Override
    public Date getExpireDate() {
        return expirationDate;
    }

    @Override
    public double actualValueNow(double leftDatePercentage) {
        return super.getSoldPrice();
    }
}
