package leetcodeSolution;

import java.util.*;

/*
There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

 time: O(V + E)
 space: O(V + E)
 */
public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] res = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < prerequisites.length; i++){
            graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        int[] visited = new int[numCourses];
        Queue<Integer> st = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(!dfs(i, visited, st, graph)){
                return new int[0];
            }
        }
        int i = 0;
        while(!st.isEmpty()){
            res[i++] = st.poll();
        }
        return res;
    }

    public boolean dfs(int i, int[] visited, Queue<Integer> st, List<List<Integer>> graph){
        if(visited[i] == 2) return true;
        if(visited[i] == 1) return false;
        visited[i] = 1;
        for(int j = 0; j < graph.get(i).size(); j++){
            if(!dfs(graph.get(i).get(j),visited, st, graph)){
                return false;
            }
        }
        visited[i] = 2;
        st.offer(i);
        return true;
    }

    public static void main(String[] args) {
        CourseScheduleII res = new CourseScheduleII();
        int numCourses = 4;
        int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
        System.out.println(Arrays.toString(res.findOrder(numCourses, prerequisites)));
    }
    }
