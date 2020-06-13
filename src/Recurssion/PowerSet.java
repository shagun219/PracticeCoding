package Recurssion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class PowerSet {

    public List<Set<Integer>> getPowerSet(Set<Integer> gSet) {
        if(gSet == null) {
            return null;
        }
        List<Set<Integer>> powerSet = new ArrayList<>();
        if(gSet.size() == 1) {
            Set<Integer> baseSet = new HashSet<>();
            baseSet.add((Integer)gSet.toArray()[0]);
            powerSet.add(baseSet);
        }
        else {
            Object []setArr = gSet.toArray();
            Integer lastEle = (Integer) setArr[setArr.length - 1];
            Set<Integer> subSet = new HashSet<>();
            for(int i=0; i<setArr.length-1; i++) {
                subSet.add((Integer)setArr[i]);
            }
            powerSet = getPowerSet(subSet);
            List<Set<Integer>> powerSetAdd = new ArrayList<>();
            for(Set<Integer> ss: powerSet) {
                Set<Integer> addSubSet = new HashSet<>(ss);
                addSubSet.add(lastEle);
                powerSetAdd.add(addSubSet);
            }
            powerSet.addAll(powerSetAdd);
            Set<Integer> lastBaseSet = new HashSet<>();
            lastBaseSet.add(lastEle);
            powerSet.add(lastBaseSet);
        }
        return powerSet;
    }
}
