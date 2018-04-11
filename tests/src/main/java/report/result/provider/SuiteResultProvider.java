package report.result.provider;

import org.testng.ISuite;
import org.testng.ISuiteResult;
import report.result.SuiteResult;
import report.result.TestResult;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SuiteResultProvider {

    private TestResultProvider testResultProvider = new TestResultProvider();

    public SuiteResult get(ISuite iSuite) {
        return new SuiteResult() {
            @Override
            public String getName() {
                return iSuite.getName();
            }

            @Override
            public List<TestResult> getTestsResults() {
                Map<String, ISuiteResult> suiteResults = iSuite.getResults();
                return suiteResults.entrySet()
                        .stream()
                        .map(entry -> testResultProvider.get(entry.getValue().getTestContext()))
                        .collect(Collectors.toList());
            }

            @Override
            public int passed() {
                return Math.toIntExact(getTestsResults()
                        .stream()
                        .collect(Collectors.summarizingInt(testResult -> testResult.passed())).getSum());
            }
            @Override
            public int failed() {
                return Math.toIntExact(getTestsResults()
                        .stream()
                        .collect(Collectors.summarizingInt(testResult -> testResult.failed())).getSum());
            }

            @Override
            public int skipped() {
                return Math.toIntExact(getTestsResults()
                        .stream()
                        .collect(Collectors.summarizingInt(testResult -> testResult.skipped())).getSum());
            }

            @Override
            public int allStatues() {
                return passed() + failed() + skipped();
            }


        };
    }
}
