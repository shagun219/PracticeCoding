package BitManipulation;

public class PairwiseSwap {

    public int swapOddEvenPlaces(int num) {
        int even = num & 0xAAAAAAAA;
        int odd = num & 0x55555555;
        num = (even >>> 1) | (odd << 1);
        return num;
    }
}
