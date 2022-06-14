package AIAppMain;


import AI.AI;

import java.util.Scanner;

public class AIAppMain {
    public static void main(String[] args) {
        System.out.println("这是一个简单AI小程序，请输入你的问题。输入exit以随时结束此程序。");
        AI ai = new AI();
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("请输入你的问题。输入exit以随时结束此程序。");
            String input = in.next();
            if ("exit".equals(input)) {
                System.out.println("再见！");
                break;
            }
            String answer = ai.answer(input);
            System.out.println(answer);
        }

    }
}
