package TreesAndGraphs;

import java.util.ArrayList;
import java.util.List;


public class GraphNode<T> {

    protected T data;
    protected List<GraphNode<T>> adjacentNodes;
    protected Status status;

    public enum Status {
        UNVISITED,
        VISITING,
        VISITED;
    }

    public GraphNode(T data) throws NoSuchFieldException {
        if(data == null) {
            throw new NoSuchFieldException("Cannot create node with null data");
        }
        this.data = data;
        status = Status.UNVISITED;
        adjacentNodes = new ArrayList<>();
    }

    public T getData() {
        return data;
    }

    public List<GraphNode<T>> getAdjacentNodes() {
        return adjacentNodes;
    }

    public Status getStatus() {
        return status;
    }
}
