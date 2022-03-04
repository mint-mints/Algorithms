package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Graph {
    HashMap<Integer, Node> nodes;
    HashSet<Edge> edges;
    Graph() {
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }

}

class Node {
    int value;
    int in;
    int out;
    ArrayList<Node> nexts;
    ArrayList<Edge> edges;
    Node(int value) {
        this.value = value;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }
}

class Edge {
    int weight;
    Node from;
    Node to;
    Edge(int weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}
