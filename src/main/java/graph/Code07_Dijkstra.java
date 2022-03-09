package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

// no negative loop
public class Code07_Dijkstra {

    public static HashMap<Node, Integer> dijkstra(Node head) {
        // distanceMap中是从head出发到所有点的最小距离
        // 如果在表中没有记录，则表示从head到该点的距离为正无穷
        HashMap<Node, Integer> distanceMap = new HashMap<>();
        distanceMap.put(head, 0);
        // 已经计算完最小距离的节点
        HashSet<Node> selectedNodes = new HashSet<>();
        Node minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
        while (minNode != null) {
            int distance = distanceMap.get(minNode);
            for (Edge edge : minNode.edges) {
                Node toNode = edge.to;
                if (!distanceMap.containsKey(toNode)) {
                    distanceMap.put(toNode, edge.weight + distance);
                }
                distanceMap.put(toNode, Math.min(distanceMap.get(toNode), edge.weight + distance));
            }
            selectedNodes.add(minNode);
            minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
        }
        return distanceMap;
    }

    public static Node getMinDistanceAndUnselectedNode(HashMap<Node, Integer> distanceMap,
                                                       HashSet<Node> selectedNodes) {
        Node minNode = null;
        int minDistance = Integer.MAX_VALUE;
        for (Entry<Node, Integer> entry : distanceMap.entrySet()) {
            Node node = entry.getKey();
            int distance = entry.getValue();
            if (!selectedNodes.contains(node) && distance < minDistance) {
                minDistance = distance;
                minNode = node;
            }
        }
        return minNode;
    }

    /**
     * TODO 使用自定义堆来实现
     */
}
