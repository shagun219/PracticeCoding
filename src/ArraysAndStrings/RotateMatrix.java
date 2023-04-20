package ArraysAndStrings;

public class RotateMatrix {

    public static void main(String []args) {
        int [][]input = new int[4][4];
        initMatrix(input);
        int [][]rotated = rotateBy90Right(input);
        System.out.println("Input Matrix : ");
        printMatrix(input);
        System.out.println("Output Matrix : ");
        printMatrix(rotated);
    }

    private static void initMatrix(int [][]m) {
        for(int r=0; r<m.length; r++) {
            for(int c=0; c<m[0].length; c++) {
                m[r][c] = r*10+c;
            }
        }
    }

    private static void printMatrix(int [][]m) {
        for(int r=0; r<m.length; r++) {
            for(int c=0; c<m[0].length; c++) {
                System.out.print(m[r][c] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] rotateBy90Right(int [][]m) {
        int[][] result = new int[m.length][m[0].length];
        for(int r=0; r<m.length; r++) {
            for(int c=0; c<m[0].length; c++) {
                result[r][c] = m[m.length-1-c][r];
            }
        }
        return result;
    }
}
