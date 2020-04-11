package TreesAndGraphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javafx.util.Pair;


public class BuildOrder {

    public String getBuildOrder(List<Pair<Character, Character>> dependencyList) throws Exception {
        GraphM<Character> dependencyGraph = createGraphM(dependencyList);
        boolean [][] edgeMatrix = dependencyGraph.getEdgeMatrix();
        StringBuilder buildOrder = new StringBuilder(edgeMatrix.length);
        int numOfProjectsBuilt = 0;
        Set<Integer> skipCol = new HashSet<>();

        while(numOfProjectsBuilt <= edgeMatrix.length) {
            //Find all leaf nodes
            int numOfLeafNodesFound = 0;
            for(int col = 0; col < edgeMatrix.length ; col++) {
                if(skipCol.contains(col)) {
                    continue;
                }
                boolean foundIncomingEdge = false;
                for(int row = 0; row < edgeMatrix.length ; row++) {
                    if(edgeMatrix[row][col]) {
                        foundIncomingEdge = true;
                        break;
                    }
                }
                if(!foundIncomingEdge) {
                    numOfLeafNodesFound++;
                    //If leaf node can be built independently
                    Character leafNode = dependencyGraph.getNodes().get(col);
                    buildOrder.append(leafNode);
                    numOfProjectsBuilt++;
                    skipCol.add(col);
                    //Once built projects dependent upon it have no dependency on it any longer
                    for(int j = 0; j < edgeMatrix.length ; j++) {
                        edgeMatrix[col][j] = false;
                    }
                    break;
                }
            }
            if(numOfLeafNodesFound == 0) {
                break;
            }
        }

        if(numOfProjectsBuilt != edgeMatrix.length) {
            throw new Exception("Cyclic dependency exists, no build order found");
        }

        return buildOrder.toString();
    }

    private GraphM<Character> createGraphM(List<Pair<Character, Character>> dependencyList) {
        if(dependencyList == null || dependencyList.isEmpty()) {
            return null;
        }

        ArrayList<Character> nodes = getNodes(dependencyList);
        boolean[][] edgeMatrix = new boolean[nodes.size()][nodes.size()];

        for(Pair<Character, Character> dependencyPair : dependencyList) {
            int keyIndex = nodes.indexOf(dependencyPair.getKey());
            int valueIndex = nodes.indexOf(dependencyPair.getValue());
            edgeMatrix[keyIndex][valueIndex] = true;
        }

        GraphM<Character> dependencyGraph = new GraphM<>(nodes, edgeMatrix);
        return dependencyGraph;
    }

    private ArrayList<Character> getNodes(List<Pair<Character, Character>> dependencyList) {
        Set<Character> uniqueNodes = new LinkedHashSet<>();
        ArrayList<Character> graphNodes = new ArrayList<>();
        for(Pair<Character, Character> dependencyPair : dependencyList) {
            if(uniqueNodes.add(dependencyPair.getKey())) {
                graphNodes.add(dependencyPair.getKey());
            }
            if(uniqueNodes.add(dependencyPair.getValue())) {
                graphNodes.add(dependencyPair.getValue());
            }
        }
        return graphNodes;
    }
}
