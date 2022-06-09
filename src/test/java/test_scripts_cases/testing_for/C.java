package test_scripts_cases.testing_for;

import org.testng.Assert;
import org.testng.annotations.Test;

public class C
{
    int i = 1;
    //@Test(retryAnalyzer = MyRetryExample.class)
    @Test
    public void testSingIn()
    {
        if(i == 3)
        {
            Assert.assertTrue(true);
        }
        else
        {
            i++;
            Assert.assertTrue(false);
        }
    }
}
