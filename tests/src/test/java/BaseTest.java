import org.testng.Assert;
import org.testng.annotations.Test;

public class BaseTest {

    @Test
    public void test() {
        Assert.assertEquals(this.getClass().getName(), "BaseTest X");
    }
}
