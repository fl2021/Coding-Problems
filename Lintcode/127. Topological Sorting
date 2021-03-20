/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */

public class Solution {
    /*
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        ArrayList<DirectedGraphNode> results = new ArrayList<>();
        if (graph == null) {
            return results;
        }

        //use HashMap to count in-degree
        Map<DirectedGraphNode, Integer> map = new HashMap<>();
        for (DirectedGraphNode node : graph) {
            for (DirectedGraphNode neighbor : node.neighbors) {
                if (map.containsKey(neighbor)) {
                    map.put(neighbor, map.get(neighbor) + 1);
                } else {
                    map.put(neighbor, 1);
                }
            }
        }

        //2.find out nodes that has 0-indegree, and put it into queue
        Queue<DirectedGraphNode> queue = new LinkedList<>();
        for (DirectedGraphNode node : graph) {
            if (!map.containsKey(node)) {
                queue.offer(node);
            }
        }
        //3.bfs
        while (!queue.isEmpty()) {
            DirectedGraphNode node = queue.poll();
            results.add(node);
            for (DirectedGraphNode nei : node.neighbors) {
                map.put(nei, map.get(nei) - 1);
                if (map.get(nei) == 0) {
                    queue.offer(nei);
                }
            }
        }
        return results;
    }
}