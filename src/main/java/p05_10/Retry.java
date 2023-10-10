package p05_10;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

    private int count = 0;
    private int maxRetry = 2;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (count < maxRetry) {
            count++;
            return true;
        }

        return false;

    }
}
