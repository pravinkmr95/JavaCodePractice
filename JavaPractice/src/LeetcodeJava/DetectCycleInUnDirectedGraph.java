package LeetcodeJava;

import InterfacePractice.A;

import java.util.ArrayList;
import java.util.List;

public class DetectCycleInUnDirectedGraph {

    public boolean hasLoop(ArrayList<ArrayList<Integer>> graph,int[] visited, int node, int parent){
        if (visited[node] == 1){
            return true;
        }
        visited[node] = 1;
        for (int neighbour: graph.get(node)){
            if (visited[neighbour] == 0){
                if (hasLoop(graph, visited, neighbour, node)){
                    return true;
                }
            } else if(neighbour != parent){
                return true;
            }
        }
        return false;
    }

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] visited = new int[V];
        for (int i=0; i<V; i++){
            if (visited[i] == 0){
                if (hasLoop(adj, visited, i, -1)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void addEdge(ArrayList<ArrayList<Integer>> graph, int start, int end){
        graph.get(start).add(end);
        graph.get(end).add(start);
    }
    public static void main(String[] args) {
        int v = 5;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i=0; i<v; i++){
            graph.add(new ArrayList<>());
        }
        addEdge(graph, 0, 1);
        addEdge(graph, 1, 2);
        addEdge(graph, 1, 4);
        addEdge(graph, 2, 3);
        addEdge(graph, 3, 4);

        DetectCycleInUnDirectedGraph detectCycleInUnDirectedGraph = new DetectCycleInUnDirectedGraph();
        System.out.println(detectCycleInUnDirectedGraph.isCycle(v, graph));

    }
}
