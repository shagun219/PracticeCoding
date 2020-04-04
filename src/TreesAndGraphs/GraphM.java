package TreesAndGraphs;

import java.util.ArrayList;
import java.util.List;


public class GraphM<T> {

    protected ArrayList<T> nodes;
    protected boolean [][] edgeMatrix;

    public GraphM() {
        nodes = null;
        edgeMatrix = null;
    }

    public GraphM(ArrayList<T> nodes, boolean[][] edgeMatrix) {
        this.nodes = nodes;
        this.edgeMatrix = edgeMatrix;
    }

    public ArrayList<T> getNodes() {
        return nodes;
    }

    public boolean[][] getEdgeMatrix() {
        return edgeMatrix;
    }
}
