import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ObjectAdapter implements IClientServiceJSON {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private DataServiceJSON dataServiceJSON;

    private static ArrayNode convertToJson(File xmlFile) {
        Document xmlDocument = readIntoDocument(xmlFile);
        NodeList quotes = xmlDocument.getElementsByTagName("quote");
        ArrayNode jsonNodes = objectMapper.createArrayNode();

        for(int i = 0; i < quotes.getLength(); i++) {
            Element quote = (Element) quotes.item(i);
            JsonNode parsedNode = parseAttributesOf(quote);
            if(parsedNode != null) {
                jsonNodes.add(parsedNode);
            }
        }
        return jsonNodes;
    }

    private static JsonNode parseAttributesOf(Element quote) {
        Map<String, Object> objectMapping = new HashMap<>();
        try {
            objectMapping.put("Name", quote.getAttribute("f25"));
            objectMapping.put("Last", Double.parseDouble(quote.getAttribute("f6")));
            objectMapping.put("Change", Double.parseDouble(quote.getAttribute("f14")));
            objectMapping.put("% Change", Double.parseDouble(quote.getAttribute("f15")));
            objectMapping.put("High", Double.parseDouble(quote.getAttribute("f2")));
            objectMapping.put("Low", Double.parseDouble(quote.getAttribute("f3")));
            objectMapping.put("Time", quote.getTextContent());
            return objectMapper.valueToTree(objectMapping);
        }
        catch(NumberFormatException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private static Document readIntoDocument(File source) {
        Document document;
        var documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            documentBuilderFactory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            var documentBuilder = documentBuilderFactory.newDocumentBuilder();
            document = documentBuilder.parse(source);
            document.normalizeDocument();
            return document;
        }
        catch(ParserConfigurationException | IOException | SAXException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public double getChangeVariance(File file) {
        dataServiceJSON = new DataServiceJSON();
        ArrayNode jsonFormat = convertToJson(file);
        return dataServiceJSON.getChangeVariance(jsonFormat);
    }

    @Override
    public double getChangePercentageVariance(File file) {
        dataServiceJSON = new DataServiceJSON();
        ArrayNode jsonFormat = convertToJson(file);
        return dataServiceJSON.getChangePercentageVariance(jsonFormat);
    }
}
