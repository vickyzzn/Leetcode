package leetcodeSolution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 */
public class cloneGraph {

    HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();

    public class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return helper(node);
    }

    public UndirectedGraphNode helper(UndirectedGraphNode node) {
        if (node == null) return null;
        if (map.containsKey(node)) return map.get(node);
        UndirectedGraphNode dup = new UndirectedGraphNode(node.label);
        map.put(node, dup);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            UndirectedGraphNode clone = helper(neighbor);
            dup.neighbors.add(clone);
        }

        return dup;

    }
}
