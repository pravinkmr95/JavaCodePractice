package LeetcodeJava;

import java.util.*;

public class CloneGraph {
    public HashSet<Node> visited = new HashSet<>();
    public HashMap<Node, Node> oldToNewMap = new HashMap<>();
    public Map<Node, Node> oldToNewMap1 = new HashMap<>();

    public void dfs(Node node){
        visited.add(node);
        System.out.print(node.val + " ");
        for (Node x: node.neighbors){
            if (!visited.contains(x)){
                dfs(x);
            }
        }
    }

    public void bfs(Node node){
        Deque<Node> queue = new ArrayDeque<>();
        queue.offer(node);
        Set<Node> visited = new HashSet<>();
        visited.add(node);
        while (!queue.isEmpty()){
            Node front = queue.poll();
            System.out.print(front.val + " ");
            visited.add(front);
            for (Node adj : front.neighbors){
                if (!visited.contains(adj)){
                    queue.offer(adj);
                    visited.add(adj);
                }
            }
        }
    }


    public Node cloneGraph(Node node) {
        if (node == null){
            return node;
        }
        if (oldToNewMap.containsKey(node)){
            return oldToNewMap.get(node);
        }

        Node newNode = new Node(node.val, new LinkedList<>());
        oldToNewMap.put(node, newNode);
        for (Node adj: node.neighbors){
            newNode.neighbors.add(cloneGraph(adj));
        }
        return newNode;
    }


    public Node cloneGraph1(Node node){
        if (node == null){
            return node;
        }
        if (oldToNewMap1.containsKey(node)){
            return oldToNewMap1.get(node);
        }
        Node newNode = new Node(node.val, new ArrayList<Node>());
        oldToNewMap1.put(node, newNode);
        for (Node neighbour: node.neighbors){
            newNode.neighbors.add(cloneGraph1(neighbour));
        }
        return newNode;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        node2.neighbors.add(node1);
        node2.neighbors.add(node3);

        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.neighbors.add(node3);
        node4.neighbors.add(node1);
        CloneGraph cloneGraph = new CloneGraph();
        cloneGraph.dfs(node1);
        System.out.println();
        cloneGraph.bfs(node1);
        System.out.println();

        Node newNode = cloneGraph.cloneGraph1(node1);
        cloneGraph.dfs(newNode);
        System.out.println();
        cloneGraph.bfs(newNode);
    }
}


class Node{
    public int val;
    public List<Node> neighbors;

    Node(){
        val = 0;
        neighbors = new ArrayList<>();
    }

    Node(int _num){
        val = _num;
        neighbors = new ArrayList<>();
    }

    Node(int _num, List<Node> _adjList){
        val = _num;
        neighbors = _adjList;
    }
}
