package report;

import org.apache.commons.lang3.StringUtils;
import org.testng.*;
import org.testng.xml.XmlSuite;
import report.result.SuiteResult;
import report.result.provider.SuiteResultProvider;

import java.util.List;
import java.util.stream.Collectors;

public class PrintReport implements IReporter {
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {

        SuiteResultProvider provider = new SuiteResultProvider();

        suites.forEach(suite -> {
            SuiteResult suiteResult = provider.get(suite);
            System.out.println("# Suite: " + suiteResult.getName());
            System.out.println("Passed: " + suiteResult.passed());
            System.out.println("Failed: " + suiteResult.failed());
            System.out.println("Skipped: " + suiteResult.skipped());
            System.out.println("All tests: " + suiteResult.allStatues());
            double passedTests = Double.valueOf(suiteResult.passed()) / Double.valueOf(suiteResult.allStatues());
            System.out.println("Tests passed: " + passedTests * 100 + "%");
            suiteResult.getTestsResults().forEach(test -> {
                System.out.println("    # Test: " + test.getName());
                System.out.println("        # Groups: " + joinArray(test.includedGroups()));
                test.getTestCaseResults().forEach(testCase -> {
                    System.out.println("        ----------------------");
                    System.out.println("        # Status: " + testCase.getStatus());
                    System.out.println("        # Parameters: " + joinArray(testCase.getParameters()));
                    String exceptionMessage = testCase.getExceptionMessage();
                    if(!StringUtils.isEmpty(exceptionMessage)) {
                        System.out.println("        # Exception message: " + testCase.getExceptionMessage());
                    }
                    System.out.println("        # Instance: " + testCase.getInstanceName());
                    System.out.println("        # Method: " + testCase.getMethodName());
                    System.out.println("        ----------------------");

                });
                System.out.println("----------------------------------");
            });


        });
    }

    private String joinArray(List<String> listOfParams) {
        return  String.join(", ", listOfParams.stream().map(s -> s.toString()).collect(Collectors.toList()));
    }
}