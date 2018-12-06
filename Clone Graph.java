/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null)
            return null;
            
        HashMap<UndirectedGraphNode, UndirectedGraphNode> hm = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        UndirectedGraphNode head = new UndirectedGraphNode(node.label);
        hm.put(node, head);
        queue.add(node);
        
        while(!queue.isEmpty()){
            UndirectedGraphNode curnode = queue.poll();
            for(UndirectedGraphNode aneighbor: curnode.neighbors){//check each neighbor
                if(!hm.containsKey(aneighbor)){//if not visited,then add to queue
                    queue.add(aneighbor);
                    UndirectedGraphNode newneighbor = new UndirectedGraphNode(aneighbor.label);
                    hm.put(aneighbor, newneighbor);
                }
                
                hm.get(curnode).neighbors.add(hm.get(aneighbor));
            }
        }
        
        return head;
    }
}
