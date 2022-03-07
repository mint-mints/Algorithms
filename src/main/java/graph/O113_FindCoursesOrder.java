package graph;

import java.util.*;

public class O113_FindCoursesOrder {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses < 1) {
            return new int[]{};
        }
        if (numCourses == 1) {
            return new int[]{0};
        }
        int[] res = new int[numCourses];
        // 没有先修顺序要求
        if (prerequisites == null || prerequisites.length == 0) {
            for (int i = 0; i < numCourses; i++) {
                res[i] = i;
            }
            return res;
        }
        HashMap<Integer, Node> nodes = transform(numCourses, prerequisites);
        Queue<Node> zeroInQueue = new LinkedList<>();
        for (Node node : nodes.values()) {
            if (node.in == 0) {
                zeroInQueue.add(node);
            }
        }
        int index = 0;
        while (!zeroInQueue.isEmpty()) {
            Node cur = zeroInQueue.poll();
            res[index++] = cur.value;
            for (Node next : cur.nexts) {
                next.in--;
                if (next.in == 0) {
                    zeroInQueue.add(next);
                }
            }
        }
        // 如果有课程无法完成，返回空数组
        if (index != numCourses) {
            return new int[]{};
        }
        return res;
    }

    private HashMap<Integer, Node> transform(int numCourses, int[][] prerequisites) {
        HashMap<Integer, Node> map = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new Node(i));
        }
        for (int[] prerequisite : prerequisites) {
            int to = prerequisite[0];
            int from = prerequisite[1];
            Node toNode = map.get(to);
            Node fromNode = map.get(from);
            toNode.in++;
            fromNode.nexts.add(toNode);
        }
        return map;
    }

    private static class Node {
        int value;
        int in;
        List<Node> nexts;
        Node(int value) {
            this.value = value;
            nexts = new ArrayList<>();
        }
    }

}
