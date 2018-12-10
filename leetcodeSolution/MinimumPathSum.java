package leetcodeSolution;
/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example:

Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.

time:O(m*n)
space: O(1)
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if(grid[0].length == 0 || grid.length == 0) return 0;
        int row = grid.length;
        int col = grid[0].length;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(i == 0 || j == 0){
                    if(i == 0 && j > 0){
                        grid[i][j] += grid[i][j - 1];
                    }else if(j == 0 && i > 0){
                        grid[i][j] += grid[i - 1][j];
                    }
                }else{
                    grid[i][j] = Math.min(grid[i][j] + grid[i - 1][j], grid[i][j] + grid[i][j - 1]);
                }
            }
        }
        return grid[row - 1][col - 1];
    }

    public static void main(String[] args) {
        MinimumPathSum res = new MinimumPathSum();
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(res.minPathSum(grid));
    }
}
