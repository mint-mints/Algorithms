package graph;

import java.util.*;

public class Code04_TopologySort {

    // directed graph and no loop
    public static List<Node> sortedTopology(Graph graph) {
        if (graph == null) {
            return null;
        }
        List<Node> res = new ArrayList<>();
        Queue<Node> zeroInQueue = new LinkedList<>();
        HashMap<Node, Integer> inMap = new HashMap<>();
        for (Node node : graph.nodes.values()) {
            inMap.put(node, node.in);
            if (node.in == 0) {
                zeroInQueue.add(node);
            }
        }
        while (!zeroInQueue.isEmpty()) {
            Node cur = zeroInQueue.poll();
            res.add(cur);
            for (Node next : cur.nexts) {
                inMap.put(next, inMap.get(next) - 1);
                if (inMap.get(next) == 0) {
                    zeroInQueue.add(next);
                }
            }
        }
        return res;
    }

}
