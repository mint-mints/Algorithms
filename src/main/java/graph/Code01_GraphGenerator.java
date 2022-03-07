package graph;

public class Code01_GraphGenerator {

    /**
     * @param matrix N*3的矩阵，记录了所有的边。[weight, from节点上面的值, to节点上面的值]
     */
    public static Graph createGraph(Integer[][] matrix) {
        Graph graph = new Graph();
        for (int i = 0; i < matrix.length; i++) {
            Integer weight = matrix[i][0];
            Integer from = matrix[i][1];
            Integer to = matrix[i][2];
            if (!graph.nodes.containsKey(from)) {
                graph.nodes.put(from, new Node(from));
            }
            if (!graph.nodes.containsKey(to)) {
                graph.nodes.put(to, new Node(to));
            }
            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);
            Edge newEdge = new Edge(weight, fromNode, toNode);
            graph.edges.add(newEdge);
            fromNode.nexts.add(toNode);
            fromNode.edges.add(newEdge);
            fromNode.out ++;
            toNode.in++;
        }
        return graph;
    }

    /**
     * TODO 其他格式到Graph的转换
     */
}
