import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {
    /**
     * 冒泡排序 升序
     * 从小到大
     *
     * @param nums
     */
    public static void bubbleSort_Asc(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 改进的冒泡排序  升序
     * 设置flag标志，判断排序是否提前结束 避免运行过多次数，优化代码
     *
     * @param nums
     */
    public static void BubbleSortImprove_Asc(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            int flag = 0;
            for (int j = 0; j < n - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    flag = 1;// 进行了元素交换的标志
                }
            }
            if (flag == 0) {
                break;
            }
        }
    }
    /**
     * 改进的冒泡排序 降序
     * 设置flag标志，判断排序是否提前结束 避免运行过多次数，优化代码
     *
     * @param nums
     */
    public static void BubbleSortImprove_Des(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            int flag = 0;
            for (int j = 0; j < n - i - 1; j++) {
                if (nums[j] < nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    flag = 1;// 进行了元素交换的标志
                }
            }
            if (flag == 0) {
                break;
            }
        }
    }


    /**
     * 字符串转为ASCII码
     *
     * @param value
     */
    public static String stringToAscii(String value) {
        StringBuffer sbu = new StringBuffer();
        char[] chars = value.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i != chars.length - 1) {
                sbu.append((int) chars[i]).append(",");
            } else {
                sbu.append((int) chars[i]);
            }
        }
        return sbu.toString();
    }


    public static void main(String[] args) {
        boolean stopSort = false;
        while (!stopSort) {
            Scanner in = new Scanner(System.in);
            System.out.println("请输入排序字符串");
            String str = in.nextLine();
            boolean chooseBubbleSort = true;
            System.out.println("请选择升序和降序，0：升序；1：降序");
            int choose_num = in.nextInt();
            if (choose_num == 0) {
                chooseBubbleSort = false;
            }
//        String asciiResult = stringToAscii(str);
//        System.out.println(asciiResult);
//        int size = asciiResult.length();
            int[] arr = new int[str.length()];
            for (int i = 0; i < str.length(); i++) {
                arr[i] = str.charAt(i);
            }
//        sorting.BubbleSort(nums);
            if (chooseBubbleSort) {
                BubbleSortImprove_Des(arr);
            } else {
                BubbleSortImprove_Asc(arr);
            }

//        System.out.println(Arrays.toString(arr));
            String str_Asc = "";
            for (int i = 0; i < str.length(); i++) {
                str_Asc += (char) arr[i];
            }
            System.out.println("输入字符串：" + str);
            System.out.println("有序字符串：" + str_Asc);
            System.out.println("ASCII码值为：" + Arrays.toString(arr));

            System.out.println("输入-1以结束排序,继续则任意输入即可");
            int breakNum = in.nextInt();
            if(breakNum == -1){
                stopSort = true;
            }


        }
    }
}

