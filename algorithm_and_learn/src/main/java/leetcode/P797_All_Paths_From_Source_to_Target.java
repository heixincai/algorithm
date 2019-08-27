package leetcode;

import java.util.ArrayList;
import java.util.List;

class P797_All_Paths_From_Source_to_Target {

    // 把结果集弄成静态变量，省的传来传去
    static List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> path = new ArrayList<>();
        result.clear();
        helper(0, graph, path);
        return result;
    }

    public static void helper(int curr, int[][] graph, List<Integer> path) {

        // 将当前节点加入路径
        path.add(curr);

        // 查一下当前节点的邻接表，如果长度为0，所以到头了，把这条路径加入结果集
        if (graph[curr].length == 0) {
            result.add(path);
        } else {
            // 如果没有到头，那么查邻接表，每一个都取出来进行递归。
            for (int n : graph[curr]) {
                // 这里要注意克隆了一下路径数组，不然的话，都加到一个里面去了……
                helper(n, graph, clone(path));
            }
        }

    }

    public static List<Integer> clone(List<Integer> arr) {
        return new ArrayList<>(arr);
    }

}
