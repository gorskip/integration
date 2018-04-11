package db;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Test1 extends BaseTest{

    @Test(groups = {"script_1"}, dataProvider = "simple")
    public void test(String value) {

        Assert.assertTrue(value.contains("a"));
    }

    @Test(groups = {"script_2"}, dataProvider = "simple")
    public void test2(String value) {

        Assert.assertEquals(value, "abc");
    }


}

