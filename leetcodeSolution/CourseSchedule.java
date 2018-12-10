package leetcodeSolution;

import java.util.ArrayList;
import java.util.List;

/*
There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

Example 1:

Input: 2, [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
             To take course 1 you should have finished course 0. So it is possible.

time: O(V+E)
 */
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < prerequisites.length; i++){
            graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        int[] visited = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            if(!dfs(i, visited, graph)){
                return false;
            }
        }
        return true;
    }

    public boolean dfs(int i, int[] visited, List<List<Integer>> graph){
        if(visited[i] == 2) return true;
        if(visited[i] == 1) return false;
        visited[i] = 1;
        for(int j = 0; j < graph.get(i).size(); j++){
            if(!dfs(graph.get(i).get(j), visited, graph)){
                return false;
            }
        }
        visited[i] = 2;
        return true;
    }

    }
