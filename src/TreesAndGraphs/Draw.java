package TreesAndGraphs;

public class Draw {

    public void drawHorizontalLine(byte[] screen, int width, int x1, int x2, int y) {
        int numOfCols = width/Byte.SIZE;
        int numOfRows = screen.length/numOfCols;
        //yth pixel = yth row?
        if(y > numOfRows) {
            //throw error
        }
        int skipRows = numOfCols * y;
        int startCol = x1/Byte.SIZE;
        int startPixel = x1%Byte.SIZE;
        int endCol = x2/8;
        int endPixel = x2%8;
        if(endCol-startCol > 1) {
            for(int col = startCol+1; col<endCol; col++) {
                screen[skipRows + col] = (byte)0xFF;
            }
        }
        screen[skipRows+startCol]= (byte)((Byte.MIN_VALUE) >> startPixel);
        screen[skipRows+endCol]= (byte)((Byte.MIN_VALUE) << Byte.SIZE-endPixel-1);
    }
}
