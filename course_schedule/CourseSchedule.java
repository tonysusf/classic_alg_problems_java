import java.util.*;

/*
* javac CourseSchedule.java; java -ea CourseSchedule
*/

class CourseSchedule {
    private boolean hasCycle(int current, Map<Integer, List<Integer>> edges, boolean[] visited, boolean[] inPath) {
        if (inPath[current]) {
            return true;
        }
        if (visited[current]) {
            return false;
        }
        inPath[current] = true;
        visited[current] = true;
        if(edges.containsKey(current)) {
            for(int otherNode: edges.get(current)) {
                if(hasCycle(otherNode, edges, visited, inPath)){
                    return true;
                }
            }
        }
        inPath[current] = false;
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        System.out.println("Input - numCourses= " + numCourses + ", prerequisites=" + Arrays.deepToString(prerequisites));
        Map<Integer, List<Integer>> edges = new HashMap<>();
        boolean out = true;
        for(int[] p: prerequisites) {
            System.out.println("p is: " + Arrays.toString(p));
            if(!edges.containsKey(p[0])){
                edges.put(p[0], new ArrayList());
            }
            edges.get(p[0]).add(p[1]);
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] inPath = new boolean[numCourses];
        for(int current=0; current<numCourses; current++){
            if(hasCycle(current, edges, visited, inPath)) {
                out = false;
            }
        }
        System.out.println("Output is " + out);
        return out;
    }

    public static void main(String[] args) {
        CourseSchedule s = new CourseSchedule();

        int[][] prerequisites = {
            {1, 0}
        };
        assert s.canFinish(2, prerequisites) == true;
    }
}