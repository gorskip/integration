package db;

import org.testng.annotations.DataProvider;

public class BaseTest {

    @DataProvider(name = "simple")
    public Object[][] provider() {
        return new Object[][] {
                {"abc"}, {"ert"}, {"aret"}
        };
    }
}
