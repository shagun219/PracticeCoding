package Recurssion;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.testng.annotations.Test;


public class TestPowerSet {

    @Test
    public void testPowerSet() {
        PowerSet ps = new PowerSet();
        Set<Integer> gSet = new HashSet<>();
        gSet.add(1);
        gSet.add(2);
        gSet.add(3);
        List<Set<Integer>> psList = ps.getPowerSet(gSet);
        for(Set<Integer> ss: psList) {
            System.out.print(ss + ",");
        }
    }
}
