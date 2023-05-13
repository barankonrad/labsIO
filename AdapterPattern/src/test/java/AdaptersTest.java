import org.junit.Assert;
import org.junit.Test;

import java.io.File;

public class AdaptersTest {
    private static final File TESTS = new File("src/main/resources/tests.xml");
    private static final File SOURCE_FIRST = new File("src/main/resources/source1.xml");
    private static final File SOURCE_SECOND = new File("src/main/resources/source2.xml");

    @Test
    public void shouldReturnCorrectChangeVarianceWhenUsingObjectAdapter() {
        // arrange
        ObjectAdapter adapter = new ObjectAdapter();
        // act
        double value = adapter.getChangeVariance(TESTS);
        // assert
        Assert.assertEquals(16.666, value, 0.001);
    }

    @Test
    public void shouldReturnCorrectChangePercentageVarianceWhenUsingObjectAdapter() {
        // arrange
        ObjectAdapter adapter = new ObjectAdapter();
        // act
        double value = adapter.getChangePercentageVariance(TESTS);
        // assert
        Assert.assertEquals(165.280, value, 0.001);
    }

    @Test
    public void shouldReturnCorrectChangeVarianceWhenUsingClassAdapter() {
        // arrange
        ClassAdapter adapter = new ClassAdapter();
        // act
        double value = adapter.getChangeVariance(TESTS);
        // assert
        Assert.assertEquals(16.666, value, 0.001);
    }

    @Test
    public void shouldReturnCorrectChangePercentageVarianceWhenUsingClassAdapter() {
        // arrange
        ClassAdapter adapter = new ClassAdapter();
        // act
        double value = adapter.getChangePercentageVariance(TESTS);
        // assert
        Assert.assertEquals(165.280, value, 0.001);
    }

    @Test
    public void shouldReturnSameValuesWhenOperateOnSameFiles(){
        // arrange
        ClassAdapter classAdapter = new ClassAdapter();
        ObjectAdapter objectAdapter = new ObjectAdapter();

        // act
        double firstSetByClass = classAdapter.getChangeVariance(SOURCE_FIRST);
        double firstSetByObject = objectAdapter.getChangeVariance(SOURCE_FIRST);
        double secondSetByClass = classAdapter.getChangePercentageVariance(SOURCE_SECOND);
        double secondSetByObject = objectAdapter.getChangePercentageVariance(SOURCE_SECOND);

        // assert
        Assert.assertEquals(firstSetByClass, firstSetByObject, 0.0);
        Assert.assertEquals(secondSetByClass, secondSetByObject, 0.0);
    }
}
