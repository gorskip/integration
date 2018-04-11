package report;

import java.util.List;

public interface TestResult {

    String getName();
    List<String> includedGroups();
    List<TestCaseResult> getTestCaseResults();
}
