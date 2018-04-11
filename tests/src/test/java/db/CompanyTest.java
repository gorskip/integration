package db;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CompanyTest extends BaseTest{

    @Test(groups = {"name_script"}, dataProvider = "company")
    public void testName(String value) {
        Assert.assertTrue(value.contains("g"), "Company name " + value + " should contain \"g\" ");
    }

    @Test(groups = {"employees_script"}, dataProvider = "employees")
    public void testEmployees(Integer value) {
        Assert.assertTrue(value.intValue() < 1500, "Number of employees " + value + " should be less than 1500");
    }


}

