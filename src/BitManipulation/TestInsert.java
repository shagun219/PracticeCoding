package BitManipulation;

import org.testng.Assert;
import org.testng.annotations.Test;


public class TestInsert {

    @Test
    public void testInsertInto() {
        Insert insert = new Insert();
        int actual = insert.insertInto(1024, 19, 2, 6);
        Assert.assertEquals(actual, 1100);
    }
}
