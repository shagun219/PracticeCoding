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
            pathBuilder.setLength(pathBuilder.length() == 0 ? 0 : pathBuilder.length() - 1);
            allGraphs.add(pathBuilder.toString());
        }
        return allGraphs;
    }

    public static <T> void DepthFirstSearchConnected(GraphNode<T> node, StringBuilder pathBuilder) {
        if(node == null) {
            return;
        }
        boolean isVisited = node.visited;
        node.visited = !isVisited;
        pathBuilder.append(node.data.toString()).append(",");
        for(GraphNode<T> neighbour: node.adjacentNodes) {
            if(isVisited == neighbour.visited) {
                DepthFirstSearchConnected(neighbour, pathBuilder);
            }
        }
    }

    public static <T> List<String> BreadthFirstSearch(Graph<T> graph) {
        List<String> allGraphs = new ArrayList<String>();
        for(GraphNode<T> node: graph.nodes) {
            StringBuilder pathBuilder = new StringBuilder();
            BreadthFirstSearchConnected(node, pathBuilder);
            pathBuilder.setLength(pathBuilder.length() == 0 ? 0 : pathBuilder.length() - 1);
            allGraphs.add(pathBuilder.toString());
        }
        return allGraphs;
    }

    public static <T> void BreadthFirstSearchConnected(GraphNode<T> node, StringBuilder pathBuilder) {
        if(node == null) {
            return;
        }
        LinkedList<GraphNode<T>> queue = new LinkedList<GraphNode<T>>();
        boolean isVisited = node.visited;
        node.visited = !isVisited;
        queue.add(node);
        while(!queue.isEmpty()) {
            GraphNode<T> currentNode = queue.poll();
            pathBuilder.append(currentNode.data.toString()).append(",");;
            for(GraphNode<T> neighbour: currentNode.adjacentNodes ) {
                if(isVisited == neighbour.visited) {
                    neighbour.visited =!isVisited;
                    queue.add(neighbour);
                }
            }
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
        Queue<GraphNode<T>> queue = new LinkedList<GraphNode<T>>();
        boolean isVisited = n.visited;
        n.visited = !isVisited;
        queue.add(n);
        while(!queue.isEmpty()) {
            GraphNode<T> currentNode = queue.poll();
            for(GraphNode<T> neighbour : currentNode.adjacentNodes) {
                if(neighbour == m) {
                    return true;
                }
                else if(isVisited == neighbour.visited) {
                    neighbour.visited = !isVisited;
                    queue.add(neighbour);
                }
            }
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
        boolean isVisited = rootNode.visited;
        rootNode.visited = !isVisited;
        queue.add(rootNode);
        while(!queue.isEmpty()) {
            GraphNode<T> currentNode = queue.poll();
            for(GraphNode<T> neighbour: currentNode.adjacentNodes ) {
                if(neighbour == n) {
                    found = true;
                }
                if(isVisited == neighbour.visited) {
                    neighbour.visited =!isVisited;
                    queue.add(neighbour);
                }
            }
        }
        return found;
    }
}
