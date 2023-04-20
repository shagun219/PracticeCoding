package TreesAndGraphs;

import java.util.ArrayList;
import java.util.List;


public class GraphUtil {

    public static Graph createAcyclicUndirectionalConnectedGraph() throws NoSuchFieldException {
        GraphNode<Integer> rootNode = new GraphNode<>(5);
        GraphNode<Integer> node11 = new GraphNode<>(50);
        GraphNode<Integer> node12 = new GraphNode<>(7);
        rootNode.adjacentNodes = new ArrayList<>(2);
        rootNode.adjacentNodes.add(node11);
        rootNode.adjacentNodes.add(node12);
        GraphNode<Integer> node21 = new GraphNode<>(55);
        GraphNode<Integer> node22 = new GraphNode<>(90);
        GraphNode<Integer> node23 = new GraphNode<>(87);
        GraphNode<Integer> node24 = new GraphNode<>(64);
        node11.adjacentNodes = new ArrayList<>(4);
        node11.adjacentNodes.add(rootNode);
        node11.adjacentNodes.add(node21);
        node11.adjacentNodes.add(node22);
        node11.adjacentNodes.add(node23);
        node12.adjacentNodes = new ArrayList<>(2);
        node12.adjacentNodes.add(rootNode);
        node12.adjacentNodes.add(node24);
        node21.adjacentNodes = new ArrayList<>(1);
        node21.adjacentNodes.add(node11);
        node22.adjacentNodes = new ArrayList<>(1);
        node22.adjacentNodes.add(node11);
        node23.adjacentNodes = new ArrayList<>(1);
        node23.adjacentNodes.add(node11);
        GraphNode<Integer> node31 = new GraphNode<>(17);
        GraphNode<Integer> node32 = new GraphNode<>(18);
        node24.adjacentNodes = new ArrayList<>(3);
        node24.adjacentNodes.add(node12);
        node24.adjacentNodes.add(node31);
        node24.adjacentNodes.add(node32);
        List<GraphNode<Integer>> nodes = new ArrayList<>(1);
        nodes.add(rootNode);
        nodes.add(node11);
        nodes.add(node12);
        nodes.add(node21);
        nodes.add(node22);
        nodes.add(node23);
        nodes.add(node24);
        nodes.add(node31);
        nodes.add(node32);
        Graph<Integer> graph = new Graph(nodes);
        return graph;
    }

    public static Graph createCyclicUndirectionalConnectedGraph() throws NoSuchFieldException {
        GraphNode<Integer> rootNode = new GraphNode<>(5);
        GraphNode<Integer> node11 = new GraphNode<>(50);
        GraphNode<Integer> node12 = new GraphNode<>(7);
        rootNode.adjacentNodes = new ArrayList<>(2);
        rootNode.adjacentNodes.add(node11);
        rootNode.adjacentNodes.add(node12);
        GraphNode<Integer> node21 = new GraphNode<>(55);
        GraphNode<Integer> node22 = new GraphNode<>(90);
        GraphNode<Integer> node23 = new GraphNode<>(87);
        GraphNode<Integer> node24 = new GraphNode<>(64);
        node11.adjacentNodes = new ArrayList<>(4);
        node11.adjacentNodes.add(rootNode);
        node11.adjacentNodes.add(node21);
        node11.adjacentNodes.add(node22);
        node11.adjacentNodes.add(node23);
        node12.adjacentNodes = new ArrayList<>(2);
        node12.adjacentNodes.add(rootNode);
        node12.adjacentNodes.add(node24);
        node21.adjacentNodes = new ArrayList<>(1);
        node21.adjacentNodes.add(node11);
        node22.adjacentNodes = new ArrayList<>(1);
        node22.adjacentNodes.add(node11);
        node23.adjacentNodes = new ArrayList<>(2);
        node23.adjacentNodes.add(node11);
        node23.adjacentNodes.add(node24);
        GraphNode<Integer> node31 = new GraphNode<>(17);
        GraphNode<Integer> node32 = new GraphNode<>(18);
        node24.adjacentNodes = new ArrayList<>(4);
        node24.adjacentNodes.add(node12);
        node24.adjacentNodes.add(node31);
        node24.adjacentNodes.add(node32);
        node24.adjacentNodes.add(node23);
        node31.adjacentNodes = new ArrayList<>(1);
        node31.adjacentNodes.add(node24);
        node32.adjacentNodes = new ArrayList<>(1);
        node32.adjacentNodes.add(node24);

        List<GraphNode<Integer>> nodes = new ArrayList<>(1);
        nodes.add(rootNode);
        nodes.add(node11);
        nodes.add(node12);
        nodes.add(node21);
        nodes.add(node22);
        nodes.add(node23);
        nodes.add(node24);
        nodes.add(node31);
        nodes.add(node32);
        Graph<Integer> graph = new Graph(nodes);
        return graph;
    }

    public static Graph createAcyclicDirectionalConnectedGraph() throws NoSuchFieldException {
        GraphNode<Integer> rootNode = new GraphNode<>(5);
        GraphNode<Integer> node11 = new GraphNode<>(50);
        GraphNode<Integer> node12 = new GraphNode<>(7);
        rootNode.adjacentNodes = new ArrayList<>(2);
        rootNode.adjacentNodes.add(node11);
        rootNode.adjacentNodes.add(node12);
        GraphNode<Integer> node21 = new GraphNode<>(55);
        GraphNode<Integer> node22 = new GraphNode<>(90);
        GraphNode<Integer> node23 = new GraphNode<>(87);
        GraphNode<Integer> node24 = new GraphNode<>(64);
        node11.adjacentNodes = new ArrayList<>(3);
        node11.adjacentNodes.add(node21);
        node11.adjacentNodes.add(node22);
        node11.adjacentNodes.add(node23);
        node12.adjacentNodes = new ArrayList<>(1);
        node12.adjacentNodes.add(node24);
        GraphNode<Integer> node31 = new GraphNode<>(17);
        GraphNode<Integer> node32 = new GraphNode<>(18);
        node24.adjacentNodes = new ArrayList<>(2);
        node24.adjacentNodes.add(node31);
        node24.adjacentNodes.add(node32);
        List<GraphNode<Integer>> nodes = new ArrayList<>(1);
        nodes.add(rootNode);
        nodes.add(node11);
        nodes.add(node12);
        nodes.add(node21);
        nodes.add(node22);
        nodes.add(node23);
        nodes.add(node24);
        nodes.add(node31);
        nodes.add(node32);
        Graph<Integer> graph = new Graph(nodes);
        return graph;
    }

    public static Graph createCyclicDirectionalConnectedGraph() throws NoSuchFieldException {
        GraphNode<Integer> node0 = new GraphNode<>(0);
        GraphNode<Integer> node1 = new GraphNode<>(1);
        GraphNode<Integer> node2 = new GraphNode<>(2);
        GraphNode<Integer> node3 = new GraphNode<>(3);
        GraphNode<Integer> node4 = new GraphNode<>(4);
        GraphNode<Integer> node5 = new GraphNode<>(5);
        node0.adjacentNodes = new ArrayList<>(3);
        node0.adjacentNodes.add(node1);
        node0.adjacentNodes.add(node4);
        node0.adjacentNodes.add(node5);
        node1.adjacentNodes = new ArrayList<>(2);
        node1.adjacentNodes.add(node3);
        node1.adjacentNodes.add(node4);
        node2.adjacentNodes = new ArrayList<>(1);
        node2.adjacentNodes.add(node1);
        node3.adjacentNodes = new ArrayList<>(2);
        node3.adjacentNodes.add(node2);
        node3.adjacentNodes.add(node4);
        List<GraphNode<Integer>> nodes = new ArrayList<>(1);
        nodes.add(node0);
        nodes.add(node1);
        nodes.add(node2);
        nodes.add(node3);
        nodes.add(node4);
        nodes.add(node5);
        Graph<Integer> graph = new Graph(nodes);

        return graph;
    }
}
