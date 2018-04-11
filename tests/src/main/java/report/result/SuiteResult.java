package report.result;

import java.util.List;

public interface SuiteResult {

    String getName();
    List<TestResult> getTestsResults();
}
