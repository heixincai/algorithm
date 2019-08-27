package leetcode;

/**
 * Created by krosshuang on 2019/3/26.
 */
public class P807_Max_Increase_to_Keep_City_Skyline {

    public int maxIncreaseKeepingSkyline(int[][] grid) {

        int[] maxInRow = new int[4];
        int[] maxInCol = new int[4];

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                maxInRow[r] = Math.max(maxInRow[r], grid[r][c]);
                maxInCol[c] = Math.max(maxInCol[c], grid[r][c]);
            }
        }

        int x = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                x += Math.min(maxInRow[r], maxInCol[c]) - grid[r][c];
            }
        }

        return x;
    }

}

