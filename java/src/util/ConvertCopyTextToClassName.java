package util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Created by krosshuang on 2019/3/26.
 */
public class ConvertCopyTextToClassName {

    public static void main(String[] s) {
        String problem = "653. Two Sum IV - Input is a BST";
        String className = "P" + problem.replace(".", "").replace(" ", "_").replace("-", "_");
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
