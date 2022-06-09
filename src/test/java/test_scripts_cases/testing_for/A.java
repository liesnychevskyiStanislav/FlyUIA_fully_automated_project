package test_scripts_cases.testing_for;

import org.testng.Assert;
import org.testng.annotations.Test;

public class A
{
    //@Test(retryAnalyzer = MyRetryExample.class)
    @Test
    public void testLogin()
    {
        Assert.assertTrue(true);
    }
}
