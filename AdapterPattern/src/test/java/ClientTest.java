import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

public class ClientTest {
    private static final File TESTS = new File("src/main/resources/tests.xml");
    private static Client client;

    @Before
    public void setup(){
        // assert
        client = new Client();
    }

    @Test
    public void getChangeVariance() {
        // act
        double result = client.getChangeVariance(TESTS);
        // assert
        Assert.assertEquals(16.666, result, 0.001);
    }

    @Test
    public void getChangePercentageVariance() {
        // act
        double result = client.getChangePercentageVariance(TESTS);
        // assert
        Assert.assertEquals(165.280, result, 0.001);
    }

    @Test
    public void getLowMean() {
        // act
        double result = client.getLowMean(TESTS);
        // assert
        Assert.assertEquals(36.048, result, 0.001);
    }

    @Test
    public void getHighMean() {
        // act
        double result = client.getHighMean(TESTS);
        // assert
        Assert.assertEquals(10, result, 0.001);
    }

    @Test
    public void getChangePercentageMean(){
        // act
        double result = client.getChangePercentageMean(TESTS);
        // assert
        Assert.assertEquals(10, result, 0.001);
    }

}