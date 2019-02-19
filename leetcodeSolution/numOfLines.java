package leetcode;
/**
 * Given a screen that's represented as a 2d grid, in which 0s are off pixels and 1s are on pixels. 
 * Define a line as a having more than 2 adjcent black pixels. find the number of lines in rows, cols and diags. 

ex:
input:
[1,1,0,1]
[1,0,0,1]
[1,0,1,1]

 *
 */
public class numOfLines {
	
	int numofLines(int[][] matrix) {
		int lines = 0;
		int row = matrix.length;
		int col = matrix[0].length;
		int i = 0;
		int j = 0;
		while (i < row && j < col - 1) {
			if (matrix[i][j] == 1 && matrix[i][j + 1] == 1) {
				lines++;
				i++;
				j = 0;
			} else if (j < col - 2){
				j++;
			} else {
				i++;
				j = 0;
			}
		}
		
		i = 0;
		j = 0;
		
		while (i < row && j < col) {
			if (matrix[i][j] == 1 && matrix[i + 1][j] == 1) {
				lines++;
				j++;
				i = 0;
			} else if (i < row - 2){
				i++;
			} else {
				j++;
				i = 0;
			}
		}
		
		int[][] t = matrix;
		i = 0;
		j = 0;
		while (i < row - 1 && j < col - 1) {
			if (t[i][j] == 1 && t[i + 1][j + 1] == 1) {
				lines++;
				t[i + 1][j + 1] = 2;
			}
			i++;
		}
		
		i = 1;
		j = 1;
		int[][] a = matrix;
		while (i < row && j < col) {
			if (a[i][j] == 1 && a[i - 1][j - 1] == 1) {
				lines++;
				a[i - 1][j - 1] = 3;

			}
			j++;
		}
		return lines;
	}
	
	public static void main (String[] args) {
		numOfLines n = new numOfLines();
		int[][] matrix = {{1, 1, 0, 1}, {1, 0, 0, 1}, {1, 0, 1, 1}};
		System.out.println(n.numofLines(matrix));
	}
	
	
}
