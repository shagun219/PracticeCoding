package Recurssion;

public class MagicIndex {

    public int findMagicIndexSortedArray(int []arr) {
        int start = 0;
        int end = arr.length;;
        int mi = -1;
        while(start<end) {
            mi = start+end/2;
            if(mi == arr[mi]) {
                break;
            }
            if(arr[mi] < mi) {
                start = mi+1;
            }
            else {
                end = mi-1;
            }
        }
        return mi;
    }
}
