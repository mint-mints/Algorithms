package graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Code02_BFS {

    public static void breadthFirstSearch(Node node) {
        if (node == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> arrived = new HashSet<>();
        queue.add(node);
        arrived.add(node);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.println(cur.value);
            for (Node next : cur.nexts) {
                if (!arrived.contains(next)) {
                    queue.add(next);
                    arrived.add(next);
                }
            }
        }
    }
}
