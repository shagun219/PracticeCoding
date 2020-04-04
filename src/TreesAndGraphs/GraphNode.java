package TreesAndGraphs;

import java.util.ArrayList;
import java.util.List;


public class GraphNode<T> {

    protected T data;
    protected  boolean visited;
    protected List<GraphNode<T>> adjacentNodes;

    public GraphNode(T data) throws NoSuchFieldException {
        if(data == null) {
            throw new NoSuchFieldException("Cannot create node with null data");
        }
        this.data = data;
        visited = false;
        adjacentNodes = new ArrayList<>();
    }

    public T getData() {
        return data;
    }

    public List<GraphNode<T>> getAdjacentNodes() {
        return adjacentNodes;
    }

    public boolean isVisited() {
        return visited;
    }
}
