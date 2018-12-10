package leetcodeSolution;

import java.util.LinkedList;
import java.util.Queue;

/*
You are given a m x n 2D grid initialized with these three possible values.

-1 - A wall or an obstacle.
0 - A gate.
INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.

Example:

Given the 2D grid:

INF  -1  0  INF
INF INF INF  -1
INF  -1 INF  -1
  0  -1 INF INF
After running your function, the 2D grid should be:

  3  -1   0   1
  2   2   1  -1
  1  -1   2  -1
  0  -1   3   4

  BFS:
  time: O(mn)
  space: O(1)
 */
public class WallsandGates {
    public void wallsAndGates(int[][] rooms) {
        if(rooms == null || rooms.length == 0 || rooms[0].length == 0) return;
        int row = rooms.length;
        int col = rooms[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(rooms[i][j] == 0) q.offer(new int[]{i, j});
            }
        }

        while(!q.isEmpty()){
            int r = q.remove()[0];
            int c = q.remove()[1];
            if(r > 0 && rooms[r - 1][c] == Integer.MAX_VALUE){
                rooms[r - 1][c] = rooms[r][c] + 1;
                q.offer(new int[]{r - 1, c});
            }
            if(c > 0 && rooms[r][c - 1] == Integer.MAX_VALUE){
                rooms[r][c - 1] = rooms[r][c] + 1;
                q.offer(new int[]{r, c - 1});
            }
            if(r < row && rooms[r + 1][c] == Integer.MAX_VALUE){
                rooms[r + 1][c] = rooms[r][c] + 1;
                q.offer(new int[]{r + 1, c});
            }
            if(c < col && rooms[r][c + 1] == Integer.MAX_VALUE){
                rooms[r][c + 1] = rooms[r][c] + 1;
                q.offer(new int[]{r, c + 1});
            }
        }


    }

    }
