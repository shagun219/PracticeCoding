package BitManipulation;

public class Insert {

    public int insertInto(int n, int m, int i, int j) {
        int mLen = j-i+1;
        int mask = (1 << mLen) - 1;
        mask = ~(mask << i);
        n = n & mask;
        m = m << i;
        n = n | m;
        return n;
    }
    
}
