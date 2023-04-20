package Recurssion;

import java.util.ArrayList;
import java.util.List;


public class Permutation {

    public List<String> permWithoutDups(String gStr) {
        List<String> permutations = new ArrayList<>();
        if(gStr == null || gStr.isEmpty()) {
            return permutations;
        }
        if(gStr.length() == 1) {
            permutations.add(gStr);
            return permutations;
        }
        char ch = gStr.charAt(0);
        List<String> permutationsOfAllButOne = permWithoutDups(gStr.substring(1));
        for(String w: permutationsOfAllButOne) {
            for(int i=0; i < gStr.length(); i++) {
                String p = addCharAtIndex(w,ch,i);
                permutations.add(p);
            }
        }
        return permutations;
    }

    private String addCharAtIndex(String str, char ch, int i) {
        String begin = str.substring(0,i);
        String end = str.substring(i);
        return begin+ch+end;
    }

    //TODO
    public List<String> permWithDups(String gStr) {
        return null;
    }
}
