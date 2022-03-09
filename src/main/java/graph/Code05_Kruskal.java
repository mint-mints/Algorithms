package graph;

import java.util.*;

// undirected graph only
public class Code05_Kruskal {

    // 代替并查集的简单集合
    public static class MySets{
        public HashMap<Node, List<Node>> setMap;
        public MySets(List<Node> nodes) {
            setMap = new HashMap<>();
            for (Node cur : nodes) {
                List<Node> set = new ArrayList<>();
                set.add(cur);
                setMap.put(cur, set);
            }
        }
        public boolean isSameSet(Node from, Node to) {
            List<Node> fromSet = setMap.get(from);
            List<Node> toSet = setMap.get(to);
            return fromSet == toSet;
        }

        public void union(Node from, Node to) {
            List<Node> fromSet = setMap.get(from);
            List<Node> toSet = setMap.get(to);
            for (Node toNode: toSet) {
                fromSet.add(toNode);
                setMap.put(toNode, fromSet);
            }
        }
    }

    public static class EdgeComparator implements Comparator<Edge> {
        @Override
        public int compare(Edge o1, Edge o2) {return o1.weight - o2.weight;}
    }

    // 查看最短的边，若不形成环，就添加
    public static Set<Edge> kruskalMST(Graph graph) {
        MySets mySets = new MySets((List<Node>) graph.nodes.values());
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());
        priorityQueue.addAll(graph.edges);
        Set<Edge> res = new HashSet<>();
        while (!priorityQueue.isEmpty()) {
            Edge cur = priorityQueue.poll();
            if (!mySets.isSameSet(cur.from, cur.to)) {
                res.add(cur);
                mySets.union(cur.from, cur.to);
            }
        }
        return res;
    }
}
