package ArraysAndStrings;

import org.testng.Assert;


public class StringHasAllUniqueChars {

    public static void main(String []args){
        String sampleStrOne = "aAbcdQC#%12P";
        String sampleStrTwo = "aAbb902@@";

        Assert.assertTrue(isUniqueWithDS(sampleStrOne));
        Assert.assertFalse(isUniqueWithDS(sampleStrTwo));

        Assert.assertTrue(isUnique(sampleStrOne));
        Assert.assertFalse(isUnique(sampleStrTwo));
    }

    private static boolean isUniqueWithDS(String str) {
        boolean[] charArray = new boolean[128];
        for(char c : str.toCharArray()) {
            if(charArray[c]) {
                return false;
            }
            charArray[c] = true;
        }
        return true;
    }

    private static boolean isUnique(String str) {
        for(int i=0; i<str.length(); i++) {
            for(int j=i+1; j<str.length(); j++){
                if(str.charAt(j) == str.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }
}
