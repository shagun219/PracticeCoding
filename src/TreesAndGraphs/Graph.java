package TreesAndGraphs;

import java.util.ArrayList;
import java.util.List;


public class Graph<T> {

    List<GraphNode<T>> nodes;

    public Graph() {
        this.nodes = new ArrayList<>();
    }

    public Graph(List<GraphNode<T>> nodes) {
        this.nodes = nodes;
    }

    public boolean isEmpty() {
        return nodes.isEmpty();
    }
}
