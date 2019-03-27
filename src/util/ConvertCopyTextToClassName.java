package util;

/**
 * Created by krosshuang on 2019/3/26.
 */
public class ConvertCopyTextToClassName {

    public static void main(String[] s) {
        String problem = "1008. Construct Binary Search Tree from Preorder Traversal";

        System.out.println("P" + problem.replace(".", "").replace(" ", "_").replace("-", "_"));
    }
}
