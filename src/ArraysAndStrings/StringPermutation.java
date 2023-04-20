package ArraysAndStrings;

import org.testng.Assert;


public class StringPermutation {

    public static void main(String []args) {
        String s1 = "abc e4S2";
        String s2 = "S42e abc";
        String s3 = "dea AS42";

        //Assert.assertTrue(isPermutation(s1, s2));
        //Assert.assertFalse(isPermutation(s1, s3));

        //Palindrome permutation
        String palindrome = "Tact Coa";
        //Assert.assertTrue(isPalindromePermutation(palindrome));
        Assert.assertTrue(isPalindromePermutationBitVector(palindrome));

    }

    private static boolean isPermutation(String s1, String s2) {

        if(s1.length() != s2.length()) {
            return false;
        }

        int []charCountsS1 = getCharCounts(s1);
        int []charCountsS2 = getCharCounts(s2);
        for(int i=0; i<128; i++) {
            if(charCountsS1[i] != charCountsS2[i]) {
                return false;
            }
        }
        return true;
    }

    private static int[] getCharCounts(String str) {
        int []charCounts = new int[128];
        for(char c: str.toCharArray()) {
            charCounts[c]++;
        }
        return  charCounts;
    }

    private static boolean isPalindromePermutation(String str) {
        String strL = str.toLowerCase();
        String finalStr = strL.replaceAll(" ", "");
        int charCounts[] = new int[128];
        for(char c: finalStr.toCharArray()) {
            charCounts[c]++;
        }
        boolean foundOdd = false;
        for(int i=0; i<128; i++) {
            if(charCounts[i]%2 == 1) {
                if(foundOdd) {
                    return false;
                }
                foundOdd = true;
            }
        }
        return true;
    }

    //assumes only alphabetical characters
    private static boolean isPalindromePermutationBitVector(String str) {
        String strL = str.toLowerCase();
        String finalStr = strL.replaceAll(" ", "");
        int bitVector = createBitVector(finalStr);
        if(bitVector == 0 || checkOnlyOneBitSet(bitVector)) {
            return true;
        }
        return false;
    }

    private static int createBitVector(String str) {
        int bitVector = 0;
        for(char c : str.toCharArray()) {
            toggle(bitVector, c);
        }
        return bitVector;
    }

    private static void toggle(int bitVector, char c) {
        int numVal = Character.getNumericValue(c);
        int mask = 1 << numVal;
        if((bitVector & mask) > 0) {
            bitVector &= ~mask;
        }
        else {
            bitVector |= mask;
        }
    }

    private static boolean checkOnlyOneBitSet(int bitVector) {
        return (bitVector & (bitVector -1)) == 0;
    }
}
