package report;

import java.util.List;

public interface TestCaseResult {

    Status getStatus();
    List<String> getParameters();
    String getExceptionMessage();
    String getStackTrace();
    String getInstanceName();
    String getMethodName();

}
