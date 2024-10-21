package LeetcodeJava;

import java.util.*;

public class CourseScheduleII {
    private static final int UNVISITED = 0;
    private static final int VISITING = 1;
    private static final int VISITED = 2;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i=0; i<numCourses; i++){
            graph.add(new ArrayList<>());
        }
        for (int[] prerequisite: prerequisites){
            int course = prerequisite[0];
            int pre = prerequisite[1];
            graph.get(pre).add(course);
        }

        int[] visited = new int[numCourses];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i=0; i<numCourses; i++){
            if (visited[i] == UNVISITED){
                if (hasCycle(graph,visited, i, stack)){
                    return new int[0];
                }
            }
        }
        int[] result = new int[numCourses];
        int start=0;
        while (!stack.isEmpty()){
            result[start++] = stack.pop();
        }
        return result;
    }

    public boolean hasCycle(List<List<Integer>> graph, int[] visited, int course, Deque<Integer> stack){
        if (visited[course] == VISITING){ //visiting
            return true;
        }
        if (visited[course] == VISITED){ //visited
            return false;
        }

        visited[course] = VISITING;

        for (int neighbour: graph.get(course)){
            if (hasCycle(graph, visited, neighbour, stack)){
                return true;
            }
        }
        visited[course] = VISITED;
        stack.push(course);
        return false;
    }

    public static void main(String[] args) {
        CourseScheduleII cs2_dfs = new CourseScheduleII();
        int[][] prerequisites1 = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        System.out.println(Arrays.toString(cs2_dfs.findOrder(4, prerequisites1)));  // Output: [0, 1, 2, 3] or [0, 2, 1, 3]

        // Test case 2 (Cycle case)
        int[][] prerequisites2 = {{1, 0}, {0, 1}};
        System.out.println(Arrays.toString(cs2_dfs.findOrder(2, prerequisites2)));  // Output: []

        int[][] prerequisites3 = {{1, 0}};
        System.out.println(Arrays.toString(cs2_dfs.findOrder(2, prerequisites3)));


    }
}
