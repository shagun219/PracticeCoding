package TreesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class GraphTraversals {

    public static <T> List<String> DepthFirstSearch(Graph<T> graph) {
        List<String> allGraphs = new ArrayList<String>();
        for(GraphNode<T> node: graph.nodes) {
            StringBuilder pathBuilder = new StringBuilder();
            DepthFirstSearchConnected(node, pathBuilder);
            if(pathBuilder.length() > 0) {
                pathBuilder.setLength(pathBuilder.length() - 1);
                allGraphs.add(pathBuilder.toString());
            }
        }
        return allGraphs;
    }

    public static <T> void DepthFirstSearchConnected(GraphNode<T> node, StringBuilder pathBuilder) {
        if(node == null) {
            return;
        }
        if(node.getStatus() != GraphNode.Status.UNVISITED) {
            return;
        }

        pathBuilder.append(node.data.toString()).append(",");
        node.status = GraphNode.Status.VISITING;
        for(GraphNode<T> neighbour: node.adjacentNodes) {
            if(neighbour.getStatus() == GraphNode.Status.UNVISITED)  {
                DepthFirstSearchConnected(neighbour, pathBuilder);
            }
        }
    }

   public static <T> List<String> BreadthFirstSearch(Graph<T> graph) {
        List<String> allGraphs = new ArrayList<String>();
        for(GraphNode<T> node: graph.nodes) {
            StringBuilder pathBuilder = new StringBuilder();
            BreadthFirstSearchConnected(node, pathBuilder);
            if(pathBuilder.length() > 0) {
                pathBuilder.setLength(pathBuilder.length() - 1);
                allGraphs.add(pathBuilder.toString());
            }
        }
        return allGraphs;
    }

    public static <T> void BreadthFirstSearchConnected(GraphNode<T> node, StringBuilder pathBuilder) {
        if(node == null) {
            return;
        }
        if(node.getStatus() != GraphNode.Status.UNVISITED) {
            return;
        }
        LinkedList<GraphNode<T>> queue = new LinkedList<GraphNode<T>>();
        node.status = GraphNode.Status.VISITING;
        queue.add(node);
        while(!queue.isEmpty()) {
            GraphNode<T> currentNode = queue.poll();
            pathBuilder.append(currentNode.data.toString()).append(",");;
            for(GraphNode<T> neighbour: currentNode.adjacentNodes ) {
                if(neighbour.status == GraphNode.Status.UNVISITED) {
                    neighbour.status = GraphNode.Status.VISITING;
                    queue.add(neighbour);
                }
            }
            currentNode.status = GraphNode.Status.VISITED;
        }
    }

    public static <T> boolean pathExistsBetweenNodes(Graph<T> graph, GraphNode<T> n, GraphNode<T> m) {
        if(graph == null || graph.nodes == null || graph.nodes.isEmpty()) {
            return false;
        }
        if(n == null || m== null) {
            return false;
        }
        if(n == m) {
            return true;
        }
        List<GraphNode<T>> allNodes = graph.nodes;
        if(!nodeExitsInGraph(graph, n)) {
            return false;
        }
        for(GraphNode<T> node : graph.nodes) {
            node.status = GraphNode.Status.UNVISITED;
        }
        Queue<GraphNode<T>> queue = new LinkedList<GraphNode<T>>();
        n.status = GraphNode.Status.VISITING;
        queue.add(n);
        while(!queue.isEmpty()) {
            GraphNode<T> currentNode = queue.poll();
            for(GraphNode<T> neighbour : currentNode.adjacentNodes) {
                if(neighbour == m) {
                    return true;
                }
                else if(neighbour.status == GraphNode.Status.UNVISITED) {
                    neighbour.status = GraphNode.Status.VISITING;
                    queue.add(neighbour);
                }
            }
            currentNode.status = GraphNode.Status.VISITED;
        }
        return false;
    }

    public static <T> boolean nodeExitsInGraph(Graph<T> graph, GraphNode<T> n) {
        if(graph == null || graph.nodes == null
                || graph.nodes.isEmpty() ||n == null) {
            return false;
        }
        Queue<GraphNode<T>> queue = new LinkedList<GraphNode<T>>();
        GraphNode<T> rootNode = graph.nodes.get(0);
        if(rootNode == n) {
            return true;
        }
        boolean found = false;
        rootNode.status = GraphNode.Status.VISITING;
        queue.add(rootNode);
        while(!queue.isEmpty()) {
            GraphNode<T> currentNode = queue.poll();
            for(GraphNode<T> neighbour: currentNode.adjacentNodes ) {
                if(neighbour == n) {
                    found = true;
                }
                if(neighbour.status == GraphNode.Status.UNVISITED) {
                    neighbour.status = GraphNode.Status.VISITING;
                    queue.add(neighbour);
                }
            }
            currentNode.status = GraphNode.Status.VISITED;
        }
        return found;
    }
}
