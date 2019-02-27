package leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * https://leetcode.com/problems/rotting-oranges/
 * Created by krosshuang on 2019/2/27.
 */
public class P994_RottingOranges {


    public static void main(String[] args) {
        //int[][] arr = new int[][]{new int[]{2,1,1}, new int[]{1,1,0}, new int[]{0,1,1}};
        //int[][] arr = new int[][]{new int[]{1,2}};
        int[][] arr = new int[][]{new int[]{1}, new int[]{2}, new int[]{1}, new int[]{1}};
        int result = new P994_RottingOranges().orangesRotting(arr);
        System.out.println(result);
    }

    // 这两个数组是用来迭代相邻位置的，上下左右
    int[] dr = new int[]{-1, 0, 1, 0};
    int[] dc = new int[]{0, -1, 0, 1};

    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }

        final int R = grid.length;
        final int C = grid[0].length;

        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] == 2) {
                    int code = i * C + j; // 将一个二维坐标编码成一个数字存进队列
                    queue.add(code);
                }
            }
        }

        int count = 0;

        while (!queue.isEmpty()) {

            int length = queue.size(); // 只处理当前长度，因为这个过程会生产一些放入队列，但是是下一轮再处理

            boolean isRot = false; // 标记是否有腐烂操作

            for (int i = 0; i < length; i++) {
                int code = queue.poll();
                int r = code / C; int c = code % C;

                for (int k = 0; k < 4; k++) {
                    int nr = r + dr[k];
                    int nc = c + dc[k];

                    if (nr >= 0 && nr < R && nc >= 0 && nc < C && grid[nr][nc] == 1) {
                        // 标记腐烂操作，然后再将新的腐烂的橘子放到队列中
                        isRot = true;
                        grid[nr][nc] = 2;
                        queue.add(nr * C + nc);
                    }
                }
            }

            // 有腐烂操作，时间+1
            if (isRot) {
                count++;
            }
        }

        // 迭代一遍，如果还有1，说明是不相邻的，没法腐烂到它，返回-1
        for (int[] row : grid) {
            for (int v : row) {
                if (v == 1) {
                    return -1;
                }
            }
        }

        return count;
    }

}
