package Java8Streams;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class MapOperators {

    public static void main(String []args) {
        //Square the number of a list
        List<Integer> input = Arrays.asList(1,2,3,4,5);
        List<Integer> output = input.stream().map(MapOperators::square).collect(Collectors.toList());
        System.out.println("Output : " + output);

        //return floor and ceiling ints of given list of decimal
        //if number is an integer it should be returned as is
        List<Number> input1 = Arrays.asList(1.2, null, -3.25, 5, 11.2);
        List<Integer> output1 = input1.stream()
                        .flatMap(n -> getFloorAndCeiling(n).stream())
                        .collect(Collectors.toList());
        System.out.println("Output1 : " + output1);
    }

    private static int square(Integer n) {
        return n*n;
    }

    private static List<Integer> getFloorAndCeiling(Number num) {
        List<Integer> result = new ArrayList<>();
        if(num == null) {
            return result;
        }
        if(num.floatValue()%1 == 0) {
            result.add(num.intValue());
        }
        else {
            int iVal = num.intValue();
            if(iVal >= 0) {
                //floor
                result.add(iVal);
                //ceiling
                result.add(iVal+1);
            }
            else {
                //floor
                result.add(iVal-1);
                //ceiling
                result.add(iVal);
            }
        }
        return result;
    }
}
