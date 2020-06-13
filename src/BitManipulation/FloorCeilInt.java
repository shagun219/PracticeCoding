package BitManipulation;

public class FloorCeilInt {

    public int findFloorWithSameNumOfOnes(int num) {
        if(num == 0) {
            return num;
        }
        int numCopy = num;
        int numOfTrailingOnes = 0;
        while((numCopy & 1) == 1) {
            numOfTrailingOnes++;
            numCopy >>= 1;
        }
        if(numCopy == 0) {
           return -1;
        }
        int numOfZeros = 0;
        while((numCopy & 1) == 0 && numCopy != 0) {
            numOfZeros++;
            numCopy >>= 1;
        }
        int nonTrailingOnePos = numOfTrailingOnes + numOfZeros;

        //zero out bits to right of on trailing one and the one itself
        num &= ~((1 << (nonTrailingOnePos+1))-1);
        //add numOfTrailingOnes + 1 just to the right of non trailing one pos
        int mask = (1 << (numOfTrailingOnes+1))-1;
        mask <<= nonTrailingOnePos- (numOfTrailingOnes+1);
        num |= mask;
        return num;
    }

    public int finCeilingWithSameNumOfOnes(int num) {
        if(num == 0) {
            return -1;
        }
        int numOfTrailingZeros = 0;
        int numCopy = num;
        while((numCopy&1) == 0 && numCopy != 0) {
            numOfTrailingZeros++;
            numCopy >>= 1;
        }
        int numOfOnes = 0;
        while((numCopy & 1) == 0) {
            numOfOnes++;
            numCopy >>= 1;
        }
        int nonTrailingZeroPos = numOfTrailingZeros +  numOfOnes;
        if(nonTrailingZeroPos == 31 || nonTrailingZeroPos == 0) {
            return -1;
        }
        //Flip non trailing zero to one
        num |= 1<<nonTrailingZeroPos;
        //zero out all bits to it's right
        num &= ~((1<<nonTrailingZeroPos) - 1);
        //add numOfOnes-1 1 to extreme right
        int mask = (1 << (numOfOnes-1))-1;
        num |= mask;
        return num;
    }
}
