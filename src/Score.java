import java.util.Scanner;

public class Score {
    public static void main(String[] args) {

        // 声明六个变量， 分别代表六门科目的成绩
        int ChineseIndex = 0;
        int MathIndex = 1;
        int ForeignIndex = 2;
        int PhyIndex = 3;
        int ChemicalIndex = 4;
        int BiologyIndex = 5;

        int totalScoreCount = 6;

        // 每门课的名字
        String[] names = new String[totalScoreCount];
        names[ChineseIndex] = "语文";
        names[MathIndex] = "数学";
        names[ForeignIndex] = "外语";
        names[PhyIndex] = "物理";
        names[ChemicalIndex] = "化学";
        names[BiologyIndex] = "生物";

        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入共有多少年的成绩：");

        int yearCount = scanner.nextInt();

        double[][] scores = new double[yearCount][totalScoreCount];
        //生成每年成绩
        for (int i = 0; i < yearCount; i++) {
            for (int j = 0; j < totalScoreCount; j++) {
                scores[i][j] = 80 + Math.random() * 20;
                System.out.println("第" + (i + 1) + "年" + names[j] + "成绩为：" + scores[i][j]);
            }
        }
        //进入主循环判断
        boolean cont = true;
        while (cont) {
            System.out.println("请选择要进行的操作：");
            System.out.println("1: 求某年最好成绩\n" +
                    "2: 求某年的平均成绩\n" +
                    "3: 求所有年份最好成绩\n" +
                    "4: 求某门课历年最好成绩");
            //选择数据处理功能
            int oprtId = scanner.nextInt();

            int year = 0;
            switch (oprtId) {
                case 1:
                    // 让用户输入指定的年份
                    System.out.println("请输入要计算第几年的最好成绩");
                    year = scanner.nextInt();
                    if (year <= 0 || yearCount < year) {
                        System.out.println("非法的年份：" + year);
                        cont = false;
                        break;
                    }
                    year = year - 1;
                    // 指定年份的最好成绩的编号，开始假设是0
                    int bestOfYearScoreId = 0;
                    // 循环指定年份的成绩，找出最好的成绩

                    for (int i = 1; i < totalScoreCount; i++) {
                        if (scores[year][bestOfYearScoreId] < scores[year][i]) {
                            bestOfYearScoreId = i;
                        }
                    }
                    System.out.println("第" + (year + 1) + "年成绩最好的科目为" + names[bestOfYearScoreId] + "，成绩为" + scores[year][bestOfYearScoreId] + "。");
                    break;
                case 2:
                    System.out.println("请输入要计算第几年的平均成绩");
                    year = scanner.nextInt();
                    if (year <= 0 || yearCount < year) {
                        System.out.println("非法的年份：" + year);
                        cont = false;
                        break;
                    }
                    year = year - 1;
                    double totalCountForAvg = 0;
                    for (int i = 0; i < totalScoreCount; i++) {
                        totalCountForAvg += scores[year][i];
                    }
                    double avgOfYear = totalCountForAvg / totalScoreCount;
                    System.out.println("第" + (year + 1) + "年的平均成绩为" + avgOfYear + "。");
                    break;
                //找出所有中最高的成绩
                case 3:
                    int bestYear = 0;
                    int bestScore = 0;

                    for (int i = 0; i < yearCount; i++) {
                        for (int j = 0; j < totalScoreCount; j++) {
                            if (scores[bestYear][bestScore] < scores[i][j]) {
                                bestYear = i;
                                bestScore = j;
                            }
                        }
                    }

                    System.out.println("所有年度最好成绩为第" + (bestYear + 1) + "年的" + names[bestScore] + "，成绩为" + scores[bestYear][bestScore] + "。");
                    break;
                case 4:
                    System.out.println("请输入科目编号");
                    int subjectId = scanner.nextInt();
                    if (subjectId <= 0 || totalScoreCount < subjectId) {
                        System.out.println("非法的科目编号：" + subjectId);
                        cont = false;
                        break;
                    }
                    subjectId = subjectId - 1;
                    year = 0;
                    for (int i = 1; i < yearCount; i++) {
                        if (scores[year][subjectId] < scores[i][subjectId]) {
                            year = i;
                        }
                    }
                    System.out.println("第" + (year + 1) + "年度" + names[subjectId] + "成绩最好，为" + scores[year][subjectId] + "。");

                    break;
                default:
                    cont = false;
                    System.out.println("不支持：" + oprtId + "， 程序结束。");
            }
        }

    }
}