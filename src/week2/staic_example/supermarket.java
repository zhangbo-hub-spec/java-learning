package week2.staic_example;

public class supermarket {

    public static double BASE_DISCOUNT;

    public static double VIP_DISCOUNT;

    public static double SVIP_DISCOUNT;


    static {
        BASE_DISCOUNT = 0.99;
        VIP_DISCOUNT = 0.85;
        SVIP_DISCOUNT = 0.75;


        System.out.println("静态代码块1里的SVIP_DISCOUNT" + SVIP_DISCOUNT);
    }

    static {
        SVIP_DISCOUNT = 0.1;
        System.out.println("静态代码块2里的SVIP_DISCOUNT" + SVIP_DISCOUNT);
    }

    public static double getDiscount() {
        return BASE_DISCOUNT;
    }

    public static double getDiscount(boolean isVIP) {

        // double abc = true ? "" : 0;

        double svipDiscount = (isVIP ? VIP_DISCOUNT : 1);
        return getDiscount() * svipDiscount;
    }

    public static double getDiscount(int svipLevel) {
        double ret = getDiscount() * VIP_DISCOUNT;
        for (int i = 0; i < svipLevel; i++) {
            ret *= SVIP_DISCOUNT;
        }
        return ret;
    }

    public static int getDiscount(int a, int b) {
        return a > b ? a : b;
    }

    public static boolean getDiscount(int a, int b, int c) {
        return a > b && b > c;
    }

    public static String getDiscount(long abc) {
        return "" + abc;
    }

    public static void main(String[] args) {
        getDiscount(1, 2);
        System.out.println("最终main 方法中使用的SVIP_DISCOUNT是" + SVIP_DISCOUNT);
    }

}
