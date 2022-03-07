package graph;

import java.util.HashSet;
import java.util.Stack;

public class Code03_DFS {

    public static void depthFirstSearch(Node node) {
        if (node == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        HashSet<Node> arrived = new HashSet<>();
        stack.add(node);
        arrived.add(node);
        System.out.println(node.value);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            for (Node next : cur.nexts) {
                if (!arrived.contains(next)) {
                    stack.push(cur);
                    stack.push(next);
                    arrived.add(next);
                    System.out.println(next.value);
                    break;
                }
            }
        }
    }

}
