package graph;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

// undirected graph only
public class Code06_Prim {

    public static class EdgeComparator implements Comparator<Edge> {
        @Override
        public int compare(Edge o1, Edge o2) {return o1.weight - o2.weight;}
    }

    // 从任意一个节点出发，依次使用最短边
    public static Set<Edge> primMST(Graph graph) {
        Set<Edge> res = new HashSet<>();
        // provide the shortest edge
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());
        // record the nodes which has arrived
        HashSet<Node> arrivedSet = new HashSet<>();
        // the for-loop set for forest
        for (Node node: graph.nodes.values()) {
            if (!arrivedSet.contains(node)) {
                priorityQueue.addAll(node.edges);
                arrivedSet.add(node);
                while (!priorityQueue.isEmpty()) {
                    Edge edge = priorityQueue.poll();
                    Node toNode = edge.to;
                    if (!arrivedSet.contains(toNode)) {
                        res.add(edge);
                        arrivedSet.add(toNode);
                        priorityQueue.addAll(toNode.edges);
                    }
                }
            }

        }
        return res;
    }

}
