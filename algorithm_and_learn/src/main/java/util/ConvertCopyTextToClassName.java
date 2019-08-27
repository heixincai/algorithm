package util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

/**
 * Created by krosshuang on 2019/3/26.
 */
public class ConvertCopyTextToClassName {

    public static void main(String[] s) {
        System.out.print("Plz input question name:");
        Scanner scanner = new Scanner(System.in);
        String problem = scanner.nextLine();
        //String problem = "107. Binary Tree Level Order Traversal II";
        String className = "P" + problem.replace("", "").replace(" ", "_").replace("-", "_");
        String fileName = "java" + File.separator + "src" + File.separator + "leetcode" + File.separator + className + ".java";

        System.out.println(fileName);

        File f = new File(fileName);
        try {
            f.createNewFile();
            Files.write(f.toPath(), ("package leetcode;\n\nclass " + className + " {\n\n}\n").getBytes(), StandardOpenOption.WRITE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
