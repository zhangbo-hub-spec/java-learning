import week3.supermarket.*;

import java.util.Date;

public class RunMarketAppMain {
    public static void main(String[] args) {

        Date produceDate = new Date();
        Date expireDate = new Date(produceDate.getTime() + 365L * 24 * 3600 * 1000);
        GamePointCard gamePointCard = new GamePointCard(
                "手机001", "Phone001", 100, 1999, 999, Category.GAMES,
                produceDate, expireDate
        );

        Snacks snacks = new Snacks(
                "薯片","chips001",100,5,2.5,Category.FOOD,
                "乐事","土豆",produceDate,expireDate
        );

        Phone phone = new Phone(
                "Iphone13", "Phone001", 100, 5999, 4999,
                Category.PHONE, 5.5, 3.9, 4, 256, "APPLE", "IOS",
                produceDate, expireDate
        );

        Processor processor = new Processor(
                "i5-12400f","CPU001",50,1999,1000,Category.CPU,"Intel",
                "Golden Cove",4.7,produceDate,expireDate
        );

        System.out.println("---------------" + phone.name + "---------------");
        phone.describe();
        phone.describePhone();
        System.out.println("---------------" + snacks.name + "---------------");
        snacks.describe();
        snacks.describeSnacks();
        System.out.println("---------------" + gamePointCard.name + "---------------");
        gamePointCard.describe();
        System.out.println("---------------" + processor.name + "---------------");
        processor.describe();
        processor.describeProcessors();



    }

}
