package Recurssion;

import java.util.List;


public class Brackets {

    public String getAllValidBracketCombinations(int numOfBrackets) {
        if(numOfBrackets <= 0) {
            throw new IllegalArgumentException();
        }
        if(numOfBrackets == 1) {
            return "()";
        }
        int numOfLeftBrackets = numOfBrackets-1;
        int numOfRightBrackets = numOfBrackets;
        StringBuilder result = new StringBuilder();
        result.append("(");
        return null;
    }

    private List<String> combination(int left, int right, StringBuilder sb) {
        if(left == 0) {
            for(int i=0; i<right; i++) {
                sb.append(")");
            }
        }
        return null;
    }
}
