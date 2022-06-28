package week4.file;

import week4.file.fileInputAndOutput.createFile;
import week4.file.fileInputAndOutput.inputAndOutput;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FIleAppMain {

    public static boolean isWriteOrRead = false;
    public static boolean isContinue = true;

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        String filenames = null;

        File path = new File("D://java_test");

        createFile cF = new createFile(path);

        inputAndOutput IO = new inputAndOutput();

        File dir = cF.createDirs();


        while (isContinue) {
            if (!isWriteOrRead) {
                System.out.println("请在目录" + dir + "下创建所需的操作");
                System.out.println("1.创建文件夹 " +
                        " 2.重命名文件夹 " +
                        " 3. 创建文件  " +
                        " 4.重命名文件 " +
                        " 5.删除文件 " +
                        " 6.删除文件夹 " +
                        " 7.创建完成,退出创建 " +
                        " 8.推出程序 ");

                int mode = scanner.nextInt();
                dir = dirModeSwitch(mode, cF, dir);
                filenames = fileModeSwitch(mode, cF, dir, filenames);
            } else {
                System.out.println("请在目录下" + dir + filenames + "进行读写文件操作");
                System.out.println(" 1.进行写操作 " +
                        " 2.传统读入方式 " +
                        " 3 改进读入方式 " +
                        " 4.读写完成,进行创建文件夹 " +
                        " 5.读写完成，推出程序 ");
                int mode = scanner.nextInt();
                inputAndOutputSwitch(mode, IO, dir, filenames);

            }


        }

    }

    public static File dirModeSwitch(int mode, createFile cf, File path) throws IOException {

        switch (mode) {
            case 1: {
                File dir = cf.createDirs();
                return dir;
            }

            case 2: {
                File dir = cf.renameDir(path);

                if (dir == null) {
                    break;
                } else {
                    return dir;
                }
            }
            case 6: {
                cf.deleteDir(path);
                return path;
            }
            case 7:
                isWriteOrRead = true;
                break;
            case 8:
                isContinue = false;
                break;
            default:
                break;


        }
        return path;
    }

    public static String fileModeSwitch(int mode, createFile cf, File path, String fileNames) throws IOException {

        switch (mode) {
            case 3: {
                String fileName = cf.createFiles(path);
                return fileName;
            }
            case 4: {
                if (fileNames == null) {
                    System.out.println("文件名为空无法读取");

                } else {
                    String fileName = cf.renameFiles(path, fileNames);
                    return fileName;
                }
            }
            case 5: {
                cf.deleteFiles(path, fileNames);
                return fileNames;
            }
            default:
                break;
        }

        return fileNames;
    }

    public static void inputAndOutputSwitch(int mode, inputAndOutput IO, File path, String fileNames) throws IOException {
        switch (mode) {
            case 1:
                IO.writeToFile(new File(path + fileNames + ".txt"));
                break;
            case 2:
                IO.classicWay(new File(path + fileNames + ".txt"));
                break;
            case 3:
                IO.improveWay(new File(path + fileNames + ".txt"));
                break;
            case 4:
                isWriteOrRead = false;
                break;
            case 5:
                isContinue = false;
                break;
            default:
                break;


        }
    }


}
