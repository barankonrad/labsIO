import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.util.ArrayList;
import java.util.List;

public class DataServiceJSON {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private JsonNode document;

    private List<Double> getListOf(String attribute) {
        List<Double> list = new ArrayList<>();
        for(JsonNode quote : document) {
            double value = quote.get(attribute).doubleValue();
            list.add(value);
        }
        return list;
    }

    private ArrayNode filterNegativeValues(ArrayNode jsonNodes) {
        ArrayNode filtered = objectMapper.createArrayNode();
        for(JsonNode node : jsonNodes) {
            try {
                double changeValue = node.get("Change").doubleValue();
                double changePercentageValue = node.get("% Change").doubleValue();
                if(changeValue >= 0 && changePercentageValue >= 0) {
                    filtered.add(node);
                }
            }
            catch(NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }
        return filtered;
    }

    private double calculateVarianceOf(String attribute) {
        var values = getListOf(attribute);
        double mean = values.stream()
                .mapToDouble(v -> v)
                .average()
                .orElse(0.0);

        return values.stream()
                .mapToDouble(v -> Math.pow(v - mean, 2))
                .average()
                .orElse(0.0);
    }

    public double getChangeVariance(ArrayNode jsonNodes) {
        document = filterNegativeValues(jsonNodes);
        return calculateVarianceOf("Change");
    }

    public double getChangePercentageVariance(ArrayNode jsonNodes) {
        document = filterNegativeValues(jsonNodes);
        return calculateVarianceOf("% Change");
    }
}
