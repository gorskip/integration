import org.apache.commons.lang3.StringUtils;
import org.testng.*;
import org.testng.xml.XmlSuite;
import report.SuiteResult;
import report.SuiteResultProvider;

import java.util.List;
import java.util.stream.Collectors;

public class MyReport implements IReporter {
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {

        SuiteResultProvider provider = new SuiteResultProvider();

        suites.forEach(suite -> {
            SuiteResult suiteResult = provider.get(suite);
            System.out.println("# Suite: " + suiteResult.getName());
            suiteResult.getTestsResults().forEach(test -> {
                System.out.println("    # Test: " + test.getName());
                test.getTestCaseResults().forEach(testCase -> {
                    System.out.println("----------------------");
                    System.out.println("        # Status: " + testCase.getStatus());
                    System.out.println("        # Parameters: " + joinArray(testCase.getParameters()));
                    String exceptionMessage = testCase.getExceptionMessage();
                    if(!StringUtils.isEmpty(exceptionMessage)) {
                        System.out.println("        # Exception message: " + testCase.getExceptionMessage());
                    }
                    System.out.println("        # Instance: " + testCase.getInstanceName());
                    System.out.println("        # Method: " + testCase.getMethodName());
                    System.out.println("----------------------");

                });
                System.out.println("----------------------------------");
            });


        });
    }

    private String joinArray(List<String> listOfParams) {
        return  String.join(", ", listOfParams.stream().map(s -> s.toString()).collect(Collectors.toList()));
    }
}