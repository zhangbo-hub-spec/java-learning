package week4.file.fileInputAndOutput;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class createFile {
    private File root;

    private static Scanner scanner = new Scanner(System.in);

    public createFile(File fileRoot) {
        this.root = fileRoot;
    }

    public void changeRoot(File fileRoot) {
        this.root = fileRoot;
    }

    /**
     * 删除文件夹
     *
     * @param newDir
     */

    public void deleteDir(File newDir) {
        System.out.println("删除文件夹？");

        boolean deleteDir = scanner.nextBoolean();

        // TODO 删除文件夹的前提是文件夹是空的，否则将删除失败
        if (deleteDir) {
            System.out.println("删除文件夹：" + newDir.delete());
        } else {
            System.out.println("删除失败，请重新再试");
        }
    }

    /**
     * 删除文件
     *
     * @param newDir
     * @param fileNameNew
     */
    public void deleteFiles(File newDir, String fileNameNew) {
        System.out.println("删除文件？");

        boolean deleteFiles = scanner.nextBoolean();

        if (deleteFiles) {
            File fn = new File(newDir, fileNameNew + ".txt");
            System.out.println("删除文件" + fn.delete());
        }
    }

    /**
     * 重新命名文件
     *
     * @param newDir
     * @param fileName
     * @return
     */
    public String renameFiles(File newDir, String fileName) {
        System.out.println("请输入新的文件名的前缀：");
        String fileNameNew = scanner.next().trim();

        File f = new File(newDir, fileName + ".txt");
        File fn = new File(newDir, fileNameNew + ".txt");
        System.out.println("重命名文件" + f.getName() + "：" + f.renameTo(fn));

        return fileNameNew;
    }

    public String createFiles(File newDir) throws IOException {
        System.out.println("请输入文件名的前缀：");
        String fileName = scanner.next().trim();
        File f = new File(newDir, fileName + ".txt");
        System.out.println("创建文件" + f.getName() + "：" + f.createNewFile());
        return fileName;
    }

    /**
     * 重命名路径名
     *
     * @param dir
     * @return
     */
    public File renameDir(File dir) {
        System.out.println("请输入新的文件夹的名字：");
        String newDirName = scanner.nextLine().trim();

        File newDir = new File(dir.getParentFile(), newDirName);
        boolean renameSuccess = dir.renameTo(newDir);

        if (renameSuccess) {
            System.out.println("改名为" + newDirName + "成功");
        } else {
            System.out.println("改名为" + newDirName + "失败");
            return null;
        }
        return newDir;
    }

    public File createDirs() {

        List<String> pathList = new ArrayList<>();
        while (true) {
            System.out.println("请输入文件路径，如果为空则结束");
            String path = scanner.nextLine();
            if (path.isBlank()) {
                break;
            }
            pathList.add(path);
        }

        return createDir(pathList.toArray(new String[0]));
    }

    public File createDir(String... restPaths) {
        String rest = joinRestDir(restPaths);
        System.out.println("将在" + root + "下创建" + rest);
        File dir = new File(root, rest);
        if (dir.exists() && dir.isDirectory()) {
            System.out.println("文件夹已经存在" + dir.toString());
            return dir;
        } else {
            boolean createSuccess = dir.mkdirs();
            if (createSuccess) {
                return dir;
            } else {
                throw new IllegalArgumentException("无法在" + root + "下创建" + rest);
            }
        }
    }

    public String joinRestDir(String... restPaths) {
        return Arrays.stream(restPaths).map(String::trim).collect(Collectors.joining(File.separator));

    }



}
