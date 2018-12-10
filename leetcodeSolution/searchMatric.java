package leetcodeSolution;
/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
Example 1:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
Output: true

time: O(m + n) ---Two Pointer
time: O(log(mn)) --- Binary Search
 */
public class searchMatric {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int row = matrix.length;
        int col = matrix[0].length;
        int lo = 0; int hi = col - 1;
        while(lo < row && hi >= 0){
            if(matrix[lo][hi] == target) return true;
            if(matrix[lo][hi] < target) {
                lo++;
            }else{
                hi--;
            }
        }
        return false;
    }
    public boolean searchMatrix2(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int row = matrix.length;
        int col = matrix[0].length;
        //by row
        int lo = 0;
        int hi = row - 1;
        while(lo <= hi){
            int mid = (lo + hi)/2;
            if(matrix[mid][0] == target) return true;
            if(matrix[mid][0] < target) {
                lo = mid + 1;
            }else{
                hi = mid - 1;
            }
        }

        if(lo == 0) return false;
        //by col
        int row_idx = lo - 1;
        lo = 0;
        hi = col - 1;
        while(lo <= hi){
            int mid = (lo + hi)/2;
            if(matrix[row_idx][mid] == target) return true;
            if(matrix[row_idx][mid] < target ){
                lo = mid + 1;
            }else{
                hi = mid - 1;
            }
        }
        return false;
    }


    }
