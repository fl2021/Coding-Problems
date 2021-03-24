public class Solution {
    /**
     * @param numCourses: a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: true if can finish all courses or false
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // write your code here
        if (numCourses == 0 || prerequisites.length == 0) {
            return true;
        }
        //1.Build the gragh; key -> value; pre course -> must course
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new HashSet<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int must = prerequisites[i][0];
            int pre = prerequisites[i][1];
            map.get(pre).add(must);
        }
        //2. find out course that has 0 in-degree
        // key -> value; course -> in degree
        Map<Integer, Integer> indegree = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            for (Integer course : map.get(i)) {
                if (indegree.containsKey(course)) {
                    indegree.put(course, indegree.get(course) + 1);
                } else {
                    indegree.put(course, 1);
                }
            }
        }

        //3.find out nodes that has 0-indegree, and put it into queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (!indegree.containsKey(i)) {
                queue.offer(i);
            }
        }
        //4.bfs
        List<Integer> finished = new ArrayList<>();
        while (!queue.isEmpty()) {
            int course = queue.poll();
            finished.add(course);
            for (Integer neighbor : map.get(course)) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if (indegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        //4.check if it's possible to finish all course?
        //return finished.size() == numCourses;
        if (finished.size() == numCourses) {
            return true;
        }
        return false;


    }
}