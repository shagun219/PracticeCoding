package ArraysAndStrings;

import org.testng.Assert;


public class OneEditAway {

    public static void main(String []args){
        String s1 = "pale";
        String s2 = "ple";
        String s3 = "pales";
        String s4 = "bale";
        String s5 = "bake";

        Assert.assertTrue(isOneEditAway(s1,s2));
        Assert.assertTrue(isOneEditAway(s3,s1));
        Assert.assertTrue(isOneEditAway(s1,s4));
        Assert.assertFalse(isOneEditAway(s1,s5));

    }

    private static boolean isOneEditAway(String s1, String s2) {
        if(s1 == null || s1.length() == 0
            || s2 == null || s2.length() == 0) {
            return false;
        }
        if(Math.abs(s1.length()-s2.length()) > 1) {
            return false;
        }
        String smaller = "";
        String longer = "";
        if(s1.length() <= s2.length()) {
            smaller = s1;
            longer = s2;
        }
        else {
            smaller = s2;
            longer = s1;
        }
        boolean foundDiff = false;
        int sindex = 0;
        int lindex = 0;
        while(sindex < smaller.length()) {
            if(smaller.charAt(sindex) != longer.charAt(lindex)) {
                if(foundDiff) {
                    return false;
                }
                foundDiff = true;
                if(smaller.length() == longer.length()) {
                    //replace use-case
                    sindex++;
                }
            }
            else {
                sindex++;
            }
            lindex++;
        }

        return true;
    }
}
