package week4.file.fileInputAndOutput;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class inputAndOutput {

    Scanner in = new Scanner(System.in);

    public void writeToFile(File targetFile) throws IOException {

        try (

                FileOutputStream fos = new FileOutputStream(targetFile);

                OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);

                PrintWriter pw = new PrintWriter(osw);
        ) {
            System.out.println("输入的内容会实时写入文件，如果输入空行则结束");
            while (true) {
                String lineToWrite = in.nextLine().trim();
                System.out.println("输入内容为" + lineToWrite);
                if (lineToWrite.trim().isBlank()) {
                    System.out.println("输入结束");
                    break;
                } else {
                    pw.println(lineToWrite);
                    pw.flush();
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public void classicWay(File sourceFile) {
        System.out.println("---------经典的处理方式-------------");
        try (

                FileInputStream fis = new FileInputStream(sourceFile);

                InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);

                BufferedReader reader = new BufferedReader(isr);
        ) {
            String line = null;

            while ((line = reader.readLine()) != null) {
                System.out.println(line.trim().toUpperCase());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public  void improveWay(File sourceFile) {
        System.out.println("---------改进的处理方式-------------");

        try (
                FileInputStream fis = new FileInputStream(sourceFile);
                InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
                BufferedReader reader = new BufferedReader(isr);
        ) {
            reader.lines().map(String::trim).map(String::toUpperCase).forEach(System.out::println);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}



