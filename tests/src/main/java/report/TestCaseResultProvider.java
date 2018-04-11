package report;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.testng.ITestResult;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestCaseResultProvider {

    public TestCaseResult get(ITestResult testResult) {
        return new TestCaseResult() {
            @Override
            public Status getStatus() {
                return new StatusMapper().map(testResult.getStatus());
            }

            @Override
            public List<String> getParameters() {
               return Arrays.asList(testResult.getParameters())
                       .stream()
                       .map(param -> param.toString())
                       .collect(Collectors.toList());
            }

            @Override
            public String getExceptionMessage() {
                return ExceptionUtils.getMessage(testResult.getThrowable());
            }

            @Override
            public String getStackTrace() {
                return ExceptionUtils.getStackTrace(testResult.getThrowable());
            }

            @Override
            public String getInstanceName() {
                return testResult.getInstanceName();
            }

            @Override
            public String getMethodName() {
                return testResult.getName();
            }
        };
    }
}
