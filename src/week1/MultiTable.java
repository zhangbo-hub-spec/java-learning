package week1;

public class MultiTable {
    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            String result = "";
            for (int j = 1; j <= i; j++) {

                result += +j + "*" + i + "=" + (j * i) + "\t";
            }
            System.out.println(result);
        }
    }
}
