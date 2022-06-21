package week3.supermarket;

import java.util.Date;

public class Processor extends MerchandiseV2 implements ExpireDateMerchandise {

    private Date produceDate;

    private Date expirationDate;

    private String Manufacturer;

    private String Core_Architecture;

    private double Frequency;

    public Processor(
            String name, String id, int count, double soldPrice, double purchasePrice, Category category,
            String Manufacturer, String Core_Architecture, double Frequency,
            Date produceDate, Date expirationDate
    ) {
        super(name, id, count, soldPrice, purchasePrice, category);
        this.produceDate = produceDate;
        this.expirationDate = expirationDate;
        this.Manufacturer = Manufacturer;
        this.Core_Architecture = Core_Architecture;
        this.Frequency = Frequency;
    }


    public void describeProcessors() {
        System.out.println("此处理器商品属性如下");
        System.out.println("生产厂家为" + Manufacturer + "\n" +
                "核心架构:" + Core_Architecture + "\n" +
                "核心频率：" + Frequency + "Hz");
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
        return this.soldPrice * (leftDatePercentage + 0.5);
    }


}
