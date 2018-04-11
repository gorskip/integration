package report.result;

import java.util.List;

public interface SuiteResult {

    String getName();
    List<TestResult> getTestsResults();
    int passed();
    int failed();
    int skipped();
    int allStatues();
}
