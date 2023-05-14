import java.io.File;

public class Client{
    private final ServiceJSON objectAdapter = new ObjectAdapter();
    private final ServiceXML dataService = new DataServiceXML();

    public double getChangeVariance(File file) {
        return objectAdapter.getChangeVariance(file);
    }

    public double getChangePercentageVariance(File file) {
        return objectAdapter.getChangePercentageVariance(file);
    }

    public double getLowMean(File file) {
        return dataService.getLowMean(file);
    }

    public double getHighMean(File file) {
        return dataService.getHighMean(file);
    }

}
