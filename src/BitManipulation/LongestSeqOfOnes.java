package BitManipulation;

import StacksNQueues.MyStack;


public class LongestSeqOfOnes {

    public int findBitToFlipToGetLongestSequenceOfOnes(int num) throws Exception {
        if(~num == 0) {
            return  Integer.SIZE;
        }
        int prevLength = 0;
        int currLength = 0;
        int maxLength = 1;
        while(num > 0) {
            if((num & 1) == 1) {
                //current bit is one
                currLength++;
            }
            else {
                //current bit is 0
                if((num & 2) == 2) {
                    //next bit is one
                    prevLength = currLength;
                }
                else {
                    prevLength = 0;
                }
                currLength = 0;
            }
            maxLength = (prevLength + 1 + currLength) > maxLength ? (prevLength + 1 + currLength) : maxLength;
            num >>>= 1;
        }
        return maxLength;
    }

}
