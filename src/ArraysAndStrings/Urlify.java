package ArraysAndStrings;

public class Urlify {

    public static void main(String []args){
        String sampleStr = "Mr John Smith       ";
        char []charArray = sampleStr.toCharArray();
        urlify(charArray, 14);
        System.out.println(charArray);
    }

    private static void urlify(char []charArray, int trueLength) {
        int index = charArray.length -1;
        for(int iter = trueLength-1; iter>=0; iter--) {
            if(charArray[iter] == ' ') {
                charArray[index] = '0';
                charArray[--index] = '2';
                charArray[--index] = '%';
            }
            else {
                charArray[index] = charArray[iter];
            }
            index--;
        }
    }
}
