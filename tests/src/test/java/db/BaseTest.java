package db;

import org.testng.annotations.DataProvider;

public class BaseTest {

    @DataProvider(name = "company")
    public Object[][] company() {
        return new Object[][] {
                {"gft"}, {"google"}, {"facebook"}
        };
    }

    @DataProvider(name = "employees")
    public Object[][] employees() {
        return new Object[][] {
                {1000}, {10000}, {2000}
        };
    }
}
