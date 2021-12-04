package com.example.problems.medium;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Input:
 * {"$id":"1",
 * "neighbors":[
 * {"$id":"2","neighbors":[{"$ref":"1"},{"$id":"3","neighbors":[{"$ref":"2"},{"$id":"4","neighbors":[{"$ref":"3"},{"$ref":"1"}],"val":4}],"val":3}],
 * "val":2},{"$ref":"4"}],
 * "val":1}
 */
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
    }

    public Node(int _val, List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class CloneGraph {

    //存储遍历过的节点
    Map<Integer, Node> map = new HashMap<>(10);

    public Node cloneGraph(Node node) {
//        Map<Node, Node> map = new HashMap<>();
//        Node cloneNode = cloneGraph(node, map);
//        Node cloneNode = cloneGraph(node, map);
        Node cloneNode = clone(node);
        return cloneNode;
    }

    private Node clone(Node node) {
        if (node == null) {
            return null;
        }
        // 如果已经遍历过，直接返回
        if (map.containsKey(node.val)) {
            return map.get(node.val);
        }
        Node newNode = new Node();
        newNode.val = node.val;
        newNode.neighbors = new ArrayList<>();
        map.put(node.val, newNode);
        for (Node oldNode : node.neighbors) {
            newNode.neighbors.add(clone(oldNode));
        }
        return newNode;
    }


    private Node cloneGraph(Node node, Map<Integer, Node> map) {
        if (node == null) return null;
        if (map.containsKey(node.val)) {
            return map.get(node.val);
        }
        Node newNode = new Node();
        newNode.val = node.val;
        map.put(node.val, newNode);
        List<Node> newNeighbors = new ArrayList<>();
        for (Node oldNode : node.neighbors) {
            newNeighbors.add(cloneGraph(oldNode, map));
        }
        newNode.neighbors = newNeighbors;
        return newNode;
    }

//    private Node cloneGraph(Node node, Map<Node, Node> map) {
//        if (node == null) return null;
//        if (map.containsKey(node)) {
//            return map.get(node);
//        }
//        Node newNode = new Node();
//        newNode.val = node.val;
//        map.put(node, newNode);
//        List<Node> newNeighbors = new ArrayList<>();
//        for (Node oldNode : node.neighbors) {
//            newNeighbors.add(cloneGraph(oldNode, map));
//        }
//        newNode.neighbors = newNeighbors;
//        return newNode;
//    }

    public static void main(String[] args) {
        CloneGraph cloneGraph = new CloneGraph();
        Node node1 = new Node();
        node1.val = 1;
        List<Node> nodeList1 = new ArrayList<>();
        List<Node> nodeList2 = new ArrayList<>();
        Node node2 = new Node();
        node2.val = 2;
        nodeList2.add(node1);
        node2.neighbors = nodeList2;
        nodeList1.add(node2);
        node1.neighbors = nodeList1;
        Node copyNode = cloneGraph.cloneGraph(node1);
        System.out.println(copyNode.val);
        copyNode.neighbors.stream().forEach(node -> System.out.println(node.val));
    }


}
