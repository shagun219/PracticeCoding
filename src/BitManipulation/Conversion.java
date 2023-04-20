package BitManipulation;

public class Conversion {

    public int numOfBitsToFlipFromNToM(int n, int m) {
        int numOfBitsToFlip = 0;
        int diff = n ^ m;
        while(diff != 0) {
            diff &= diff-1;
            numOfBitsToFlip++;
        }
        return numOfBitsToFlip;
    }
}
