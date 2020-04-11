package TreesAndGraphs;

import java.util.ArrayList;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import javafx.util.Pair;


public class TestTopologicalSort {

    @Test
    public void testBuildOrderPositive() throws Exception {

        Graph<Character> projects = new Graph<>();
        projects.nodes = new ArrayList<>();

        GraphNode<Character> projA = new GraphNode<>('a');
        GraphNode<Character> projB = new GraphNode<>('b');
        GraphNode<Character> projC = new GraphNode<>('c');
        GraphNode<Character> projD = new GraphNode<>('d');
        GraphNode<Character> projE = new GraphNode<>('e');
        GraphNode<Character> projF = new GraphNode<>('f');

        projA.adjacentNodes = new ArrayList<>();
        projA.adjacentNodes.add(projD);
        projF.adjacentNodes = new ArrayList<>();
        projF.adjacentNodes.add(projB);
        projF.adjacentNodes.add(projA);
        projB.adjacentNodes = new ArrayList<>();
        projB.adjacentNodes.add(projD);
        projD.adjacentNodes = new ArrayList<>();
        projD.adjacentNodes.add(projC);

        projects.nodes.add(projA);
        projects.nodes.add(projB);
        projects.nodes.add(projC);
        projects.nodes.add(projD);
        projects.nodes.add(projE);
        projects.nodes.add(projF);


        TopologicalSort<Character> tp = new TopologicalSort<>();
        String actualOrder = tp.buildOrder(projects);
        System.out.println("actualOrder: " + actualOrder);
    }
}
