import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataServiceXML {

    private Document document;

    private void readIntoDocument(File source) {
        var documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            documentBuilderFactory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            var documentBuilder = documentBuilderFactory.newDocumentBuilder();
            this.document = documentBuilder.parse(source);
            this.document.normalizeDocument();
        }
        catch(ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    private List<Double> getListOf(String attribute) {
        NodeList quotes = document.getElementsByTagName("quote");
        List<Double> values = new ArrayList<>();

        for(int i = 0; i < quotes.getLength(); i++) {
            Element quote = (Element) quotes.item(i);
            try {
                double parsedValue = Double.parseDouble(quote.getAttribute(attribute));
                values.add(parsedValue);
            }
            catch(NumberFormatException e) {
                values.add(0.0);
                System.out.println("NumberFormatException: " + e.getMessage());
            }
        }

        return values;
    }

    private double averageOf(String attribute) {
        List<Double> values = getListOf(attribute);
        return values.stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0.0);
    }

    public double calculateAverageHigh(File xmlFile) {
        readIntoDocument(xmlFile);
        return averageOf("f2");
    }

    public double calculateAverageLow(File xmlFile) {
        readIntoDocument(xmlFile);
        return averageOf("f3");
    }
}