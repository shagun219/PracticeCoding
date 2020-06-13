package Recurssion;

public class RecursiveMultiply {

    public int multiply(int m, int n) {
        int num, times;
        if(m < n) {
            num = n;
            times = m;
        }
        else {
            num = m;
            times = n;
        }
        return reMultiply(num, times);
    }

    public int reMultiply(int num, int times) {
        if(num==0 || times == 0) {
            return 0;
        }
        if(times == 1) {
            return num;
        }
        return num + reMultiply(num, times-1);
    }
}
