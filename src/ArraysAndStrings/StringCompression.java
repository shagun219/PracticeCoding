package ArraysAndStrings;

import org.testng.Assert;


public class StringCompression {

    public static void main(String []args) {
        String sampleStr = "aabcccccaaa";
        String expectedStr = "a2b1c5a3";

        Assert.assertEquals(compress(sampleStr), expectedStr);
        Assert.assertEquals(compress("abcdde"), "abcdde");
    }

    private static String compress(String input) {
        StringBuilder cs = new StringBuilder();
        int index = 0;
        while(index < input.length()) {
            int rindex = index+1;
            int rcount = 1;
            while(rindex < input.length() && input.charAt(rindex) == input.charAt(index)) {
                rcount++;
                rindex++;
            }
            cs.append(input.charAt(index)).append(rcount);
            index=rindex;
        }
        return cs.toString().length() < input.length() ? cs.toString() : input;
    }
}
