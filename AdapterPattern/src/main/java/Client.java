import java.io.File;

public class Client implements IClientServiceJSON, IClientServiceXML {
    private final ObjectAdapter objectAdapter = new ObjectAdapter();
    private final DataServiceXML dataService = new DataServiceXML();

    @Override
    public double getChangeVariance(File file) {
        return objectAdapter.getChangeVariance(file);
    }

    @Override
    public double getChangePercentageVariance(File file) {
        return objectAdapter.getChangePercentageVariance(file);
    }

    @Override
    public double getLowMean(File file) {
        return dataService.calculateAverageLow(file);
    }

    @Override
    public double getHighMean(File file) {
        return dataService.calculateAverageHigh(file);
    }

}
