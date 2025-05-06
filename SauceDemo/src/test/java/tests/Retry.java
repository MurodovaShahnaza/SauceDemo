package tests;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

    private int attempt = 1;
    private static final int MAX_RETRY = 3;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (!iTestResult.isSuccess()) {   //Проверить, не удался ли тест*
            if (attempt < MAX_RETRY) {   //Проверьте, достигнут ли лимит попыток
                attempt++;  //Увеличить максимальное количество попыток на 1
                iTestResult.setStatus(ITestResult.FAILURE);  //Отметить тест как неудачный
                System.out.println("Retrying once again");
                return true;  //Показывает TestNG, что нужно перезапустить тест
            } else {
                iTestResult.setStatus(ITestResult.FAILURE);   //Если достигнут максимальный счёт, тест помечается как неудачный
            }
        } else {
            iTestResult.setStatus(ITestResult.SUCCESS);  //Если тест пройден, TestNG помечает его как пройденный
        }
        return false;
    }
}
