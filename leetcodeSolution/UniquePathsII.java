package leetcodeSolution;
/*
contains obstacles

time:O(m*n)
space:O(m*n)
 */
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int col = obstacleGrid[0].length;
        int row = obstacleGrid.length;
        int[][] dp = new int[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                }else if(i == 0 || j == 0){
                    if(i > 0 && dp[i - 1][j] == 0 || j > 0 && dp[i][j - 1] == 0){
                        dp[i][j] = 0;
                    }else{
                        dp[i][j] = 1;
                    }
                }else{
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[row - 1][col - 1];
    }

    public static void main(String[] args) {
        UniquePathsII res = new UniquePathsII();
        int[][] nums = {{0,0}};
        System.out.println(nums[0].length );
    }
}
