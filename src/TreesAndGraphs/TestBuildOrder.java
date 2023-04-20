package TreesAndGraphs;

import java.util.ArrayList;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import javafx.util.Pair;


public class TestBuildOrder {

    @Test
    public void testBuildOrderPositive() throws Exception {
        BuildOrder bo = new BuildOrder();
        List<Pair<Character, Character>> dependencyList = new ArrayList<>();
        dependencyList.add(new Pair<>('a','d'));
        dependencyList.add(new Pair<>('f','b'));
        dependencyList.add(new Pair<>('b','d'));
        dependencyList.add(new Pair<>('f','a'));
        dependencyList.add(new Pair<>('d','c'));
        String actualOrder = bo.getBuildOrder(dependencyList);
        System.out.println("actualOrder: " + actualOrder);
        Assert.assertEquals(actualOrder,"fabdc");
    }

    @Test
    public void testBuildOrderNegative() throws Exception {
        BuildOrder bo = new BuildOrder();
        List<Pair<Character, Character>> dependencyList = new ArrayList<>();
        dependencyList.add(new Pair<>('a','d'));
        dependencyList.add(new Pair<>('f','b'));
        dependencyList.add(new Pair<>('b','d'));
        dependencyList.add(new Pair<>('f','a'));
        dependencyList.add(new Pair<>('d','c'));
        dependencyList.add(new Pair<>('c','b'));
        try {
            bo.getBuildOrder(dependencyList);
            Assert.fail("Expected cyclic dependency exception");
        }
        catch(Exception ex) {
            Assert.assertEquals(ex.getMessage(), "Cyclic dependency exists, no build order found");
        }
    }
}
