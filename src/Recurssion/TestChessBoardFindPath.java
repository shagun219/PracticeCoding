package Recurssion;

import java.util.ArrayList;
import java.util.List;
import org.testng.annotations.Test;


public class TestChessBoardFindPath {

    @Test
    public void testFinPath() {
        List<Integer> blockedNodes = new ArrayList<>();
        blockedNodes.add(12);
        blockedNodes.add(13);
        blockedNodes.add(22);
        ChessBoardFindPath cb = new ChessBoardFindPath(4,4, blockedNodes);
        System.out.println(cb.findPathDR(0,0));
        System.out.println(cb.findPathDDR(0,0));
    }
}
