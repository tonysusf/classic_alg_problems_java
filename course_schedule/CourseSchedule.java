import java.util.*;

/*
* javac CourseSchedule.java; java -ea CourseSchedule
*/

class CourseSchedule {
    private boolean hasCycle(int current, List<List<Integer>> edges, boolean[] visited, boolean[] inPath) {
        if (inPath[current]) {
            return true;
        }
        if (visited[current]) {
            return false;
        }
        inPath[current] = true;
        visited[current] = true;
        for(int otherNode: edges.get(current)) {
            if(hasCycle(otherNode, edges, visited, inPath)){
                return true;
            }
        }
        inPath[current] = false;
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        System.out.println("Input - numCourses= " + numCourses + ", prerequisites=" + Arrays.deepToString(prerequisites));
        List<List<Integer>> edges = new ArrayList<>();
        boolean out = true;
        for(int i=0; i<numCourses; i++){
            edges.add(new ArrayList<Integer>());
        }

        for(int[] p: prerequisites) {
            System.out.println("p is: " + Arrays.toString(p));
            edges.get(p[0]).add(p[1]);
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] inPath = new boolean[numCourses];
        for(int current=0; current<numCourses; current++){
            if(hasCycle(current, edges, visited, inPath)) {
                out = false;
                break;
            }
        }
        System.out.println("Output is " + out);
        return out;
    }

    public static void main(String[] args) {
        CourseSchedule s = new CourseSchedule();

        // simple case
        assert s.canFinish(2, new int[][] {
                {1, 0}
            }
        ) == true;

        // cycle
        assert s.canFinish(2, new int[][] {
                {1, 0},
                {0, 1}
            }
        ) == false;

        // no prerequisites
        assert s.canFinish(3,new int[][] {}
        ) == true;

        // Simple chain: 0 -> 1 -> 2 -> 3
        assert s.canFinish(4, new int[][] {
                {1, 0},
                {2, 1},
                {3, 2}
            }
        ) == true;

        // longer cycle: 0 -> 1 -> 2 -> 0
        assert s.canFinish(3, new int[][] {
                {1, 0},
                {2, 1},
                {0, 2}
            }
        ) == false;

        // multiple prerequisites, but no cycle
        assert s.canFinish(4, new int[][] {
                {1, 0},
                {2, 0},
                {3, 1},
                {3, 2}
            }
        ) == true;

        // disconnected graph with one cycle
        assert s.canFinish(5, new int[][] {
                {1, 0},
                {3, 2},
                {2, 3}
            }
        ) == false;

        // one course
        assert s.canFinish(1, new int[][] {}
        ) == true;

        // longer valid DAG
        assert s.canFinish(6, new int[][] {
                {1, 0},
                {2, 0},
                {3, 1},
                {3, 2},
                {4, 3},
                {5, 4}
            }
        ) == true;

    }
}