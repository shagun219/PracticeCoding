package TreesAndGraphs;

import java.util.ArrayList;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestGraphTraversal {

    @Test
    public void testDFS() throws NoSuchFieldException {
        Graph<Integer> g1 = GraphUtil.createAcyclicDirectionalConnectedGraph();
        Graph<Integer> g2 = GraphUtil.createAcyclicUndirectionalConnectedGraph();
        Graph<Integer> g3 = GraphUtil.createCyclicDirectionalConnectedGraph();
        Graph<Integer> g4 = GraphUtil.createCyclicUndirectionalConnectedGraph();

        System.out.println("DFS G1 :" + GraphTraversals.DepthFirstSearch(g1));
        System.out.println("DFS G2 :" + GraphTraversals.DepthFirstSearch(g2));
        System.out.println("DFS G3 :" + GraphTraversals.DepthFirstSearch(g3));
        System.out.println("DFS G4 :" + GraphTraversals.DepthFirstSearch(g4));
    }

    @Test
    public void testBFS() throws NoSuchFieldException {
        Graph<Integer> g1 = GraphUtil.createAcyclicDirectionalConnectedGraph();
        Graph<Integer> g2 = GraphUtil.createAcyclicUndirectionalConnectedGraph();
        Graph<Integer> g3 = GraphUtil.createCyclicDirectionalConnectedGraph();
        Graph<Integer> g4 = GraphUtil.createCyclicUndirectionalConnectedGraph();

        System.out.println("BFS G1 :" + GraphTraversals.BreadthFirstSearch(g1));
        System.out.println("BFS G2 :" + GraphTraversals.BreadthFirstSearch(g2));
        System.out.println("BFS G3 :" + GraphTraversals.BreadthFirstSearch(g3));
        System.out.println("BFS G4 :" + GraphTraversals.BreadthFirstSearch(g4));
    }

    @Test
    public void testPathExistsBetweenNodes() throws NoSuchFieldException {
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

        //Assert.assertTrue(GraphTraversals.pathExistsBetweenNodes(graph, node3, node1));
        //Assert.assertTrue(GraphTraversals.pathExistsBetweenNodes(graph, node0, node2));
        Assert.assertFalse(GraphTraversals.pathExistsBetweenNodes(graph, node1, node5));
    }
}
