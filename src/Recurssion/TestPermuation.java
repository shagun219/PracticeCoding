package Recurssion;

import java.util.List;
import org.testng.annotations.Test;


public class TestPermuation {

    @Test
    public void testPermWithoutDups() {
        Permutation permutation = new Permutation();
        List<String> result = permutation.permWithoutDups("abc");
        System.out.println(result);
    }
}
