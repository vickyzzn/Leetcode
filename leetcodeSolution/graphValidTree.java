package leetcodeSolution;

import java.util.ArrayList;
import java.util.List;



/*
Given n nodes labeled from 0 to n-1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.

Example 1:

Input: n = 5, and edges = [[0,1], [0,2], [0,3], [1,4]]
Output: true
Example 2:

Input: n = 5, and edges = [[0,1], [1,2], [2,3], [1,3], [1,4]]
Output: false
Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0,1] is the same as [1,0] and thus will not appear together in edges.
 */
public class graphValidTree {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < edges.length; i++){
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        boolean[] visit = new boolean[n];
        if(hasCycle(graph, 0, visit, -1)) return false;

        return visit.length == n;

    }
    public boolean hasCycle(List<List<Integer>> graph, int u, boolean[] visit, int p) {
        visit[u] = true;
        for(int i = 0; i < graph.get(u).size(); i++){
            int v = graph.get(u).get(i);
            if (visit[v] && v != p || !visit[v] && hasCycle(graph, v, visit, u)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        graphValidTree res = new graphValidTree();
        int n = 5;
        int[][] edges = {{0,1},{0,2},{0,3},{1,4}};
        System.out.println(res.validTree(n, edges));
    }

    }
