package report.result;

import java.util.List;

public interface TestResult {

    String getName();
    List<String> includedGroups();
    List<TestCaseResult> getTestCaseResults();
    int passed();
    int failed();
    int skipped();
}
