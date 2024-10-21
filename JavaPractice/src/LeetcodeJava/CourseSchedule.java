package LeetcodeJava;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class CourseSchedule {
    private static final int UNVISITED = 0;
    private static final int VISITING = 1;
    private static final int VISITED = 2;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i=0; i<numCourses; i++){
            graph.add(new ArrayList<>());
        }
        for (int[] prerequisite: prerequisites){
            int course = prerequisite[0];
            int pre = prerequisite[1];
            graph.get(pre).add(course);
        }
//        System.out.println(graph);

        int[] visited = new int[numCourses];
        for (int i=0; i<numCourses; i++){
            if (visited[i] == UNVISITED){
                if (hashCycle(graph,visited, i)){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean hashCycle(List<List<Integer>> graph, int[] visited, int course){
        if (visited[course] == VISITING){ //visiting
            return true;
        }
        if (visited[course] == VISITED){ //visited
            return false;
        }

        visited[course] = VISITING;

        for (int neighbour: graph.get(course)){
            if (hashCycle(graph, visited, neighbour)){
                return true;
            }
        }
        visited[course] = VISITED;
        return false;
    }

    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = { {1, 0}, {2, 1}, {3, 2} };
        CourseSchedule courseSchedule = new CourseSchedule();
        System.out.println(courseSchedule.canFinish(numCourses, prerequisites));
    }
}
