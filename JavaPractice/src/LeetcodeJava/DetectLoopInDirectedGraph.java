package LeetcodeJava;

import java.util.ArrayList;
import java.util.List;

public class DetectLoopInDirectedGraph {
    private static final int UNVISITED=0;
    private static final int VISITING=1;
    private static final int VISITED=2;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i=0; i<numCourses; i++){
            graph.add(new ArrayList<>());
        }

        for (int[] prerequisite: prerequisites){
            int course = prerequisite[0];
            int prereq = prerequisite[1];
            graph.get(prereq).add(course);
        }
        //System.out.println(graph);
        int[] visited = new int[numCourses];

        for (int i=0; i<numCourses; i++){
            if (visited[i] == UNVISITED){
                if (detectLoop(graph, visited, i)){
                    System.out.println("Loop present");
                    return false;
                }
            }
        }
        return true;
    }

    public boolean detectLoop(List<List<Integer>> graph, int[] visited, int course){
        if (visited[course] == VISITING){
            return true;
        }
        if (visited[course] == VISITED){
            return false;
        }

        visited[course] = VISITING;
        for (int neighbour: graph.get(course)){
            if (detectLoop(graph, visited, neighbour)){
                return true;
            }
        }
        visited[course] = VISITED;
        return false;
    }

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1,0},{0,1}};
        DetectLoopInDirectedGraph detectLoopInDirectedGraph = new DetectLoopInDirectedGraph();
        System.out.println(detectLoopInDirectedGraph.canFinish(numCourses, prerequisites));

        int numCourses1 = 2;
        int[][] prerequisites1 = {{1,0}};
        System.out.println(detectLoopInDirectedGraph.canFinish(numCourses1, prerequisites1));
    }
}
