package report;

import org.testng.IResultMap;
import org.testng.ITest;
import org.testng.ITestContext;
import org.testng.ITestResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TestResultProvider {

    private TestCaseResultProvider testCaseResultProvider = new TestCaseResultProvider();

    public TestResult get(ITestContext iTestContext) {
        return new TestResult() {
            @Override
            public String getName() {
               return iTestContext.getName();
            }

            @Override
            public List<String> includedGroups() {
                return Arrays.asList(iTestContext.getIncludedGroups());
            }

            @Override
            public List<TestCaseResult> getTestCaseResults() {
                List<TestCaseResult> testCaseResults = new ArrayList<>();
                IResultMap failedTests = iTestContext.getFailedTests();
                IResultMap successTests = iTestContext.getPassedTests();
                IResultMap skippedTests = iTestContext.getSkippedTests();
                testCaseResults.addAll(prepareTestCaseResults(failedTests.getAllResults()));
                testCaseResults.addAll(prepareTestCaseResults(successTests.getAllResults()));
                testCaseResults.addAll(prepareTestCaseResults(skippedTests.getAllResults()));
                return testCaseResults;
            }
        };
    }

    private List<TestCaseResult> prepareTestCaseResults(Set<ITestResult> iTestResults) {
        return iTestResults
                .stream()
                .map(result -> testCaseResultProvider.get(result))
                .collect(Collectors.toList());
    }

}
