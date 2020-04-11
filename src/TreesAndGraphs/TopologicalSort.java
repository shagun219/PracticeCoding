package TreesAndGraphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import StacksNQueues.MyStack;


public class TopologicalSort<T extends Comparable> {

    /**
     * Returns DFS order of traversal for acyclic graph
     * Returns null in case the graph is cyclic and no buildOrder is possible
     */
    public String buildOrder(Graph<T> graph) {
        MyStack<T> orderStack = new MyStack<>();
        for(GraphNode<T> node: graph.nodes) {
            if(node == null) {
                continue;
            }
            if(node.status == GraphNode.Status.UNVISITED) {
                if(!dfs(node, orderStack)) {
                    return null;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!orderStack.isEmpty()) {
            sb.append(orderStack.pop().toString()).append(",");
        }
        if(sb.length() > 0) {
            sb.setLength(sb.length()-1);
        }
        return sb.toString();
    }

    private boolean dfs(GraphNode<T> node, MyStack<T> order) {
        if(node == null || node.status == GraphNode.Status.VISITING) {
            return false;
        }
        if(node.status == GraphNode.Status.VISITED) {
            return true;
        }
        node.status = GraphNode.Status.VISITING;
        for(GraphNode<T> neighbour : node.getAdjacentNodes()) {
            dfs(neighbour, order);
        }
        node.status = GraphNode.Status.VISITED;
        order.push(node.getData());
        return true;
    }

}
