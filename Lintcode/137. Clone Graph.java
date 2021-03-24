/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) {
 *         label = x;
 *         neighbors = new ArrayList<UndirectedGraphNode>();
 *     }
 * }
 */

public class Solution {
    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // write your code here
        if (node == null) {
            return node;
        } 
        //1.get node;
        List<UndirectedGraphNode> nodes = getNodes(node);
        //2.copy node;
        Map<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<>();
        for (UndirectedGraphNode bsNode : nodes) {
            UndirectedGraphNode copyNode = new UndirectedGraphNode(bsNode.label);
            map.put(bsNode, copyNode);
        }
        //3.copy neighbors;
        for (UndirectedGraphNode n : nodes) {
            UndirectedGraphNode newNode = map.get(n);
            for (UndirectedGraphNode neighbors : n.neighbors) {
                UndirectedGraphNode newNeighbors = map.get(neighbors);
                newNode.neighbors.add(newNeighbors);
            }
        }
        return map.get(node);
    }
    private List<UndirectedGraphNode> getNodes(UndirectedGraphNode node) {
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        Set<UndirectedGraphNode> set = new HashSet<>();
        queue.offer(node);
        set.add(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode curNode = queue.poll();
            for (UndirectedGraphNode m : curNode.neighbors) {
                if (!set.contains(m)) {
                    set.add(m);
                    queue.add(m);
                }
            }
        }
        return new ArrayList<UndirectedGraphNode>(set);

    }
}