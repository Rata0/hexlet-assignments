package exercise;

import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
public class Tag {
    String tagName;
    Map<String,String> attributes;
    public String toString() {
        StringBuilder builder = new StringBuilder("<" + tagName);
        for (Map.Entry<String, String> entry : attributes.entrySet()) {
            builder.append(" " + entry.getKey() + "=");
            builder.append("\"" + entry.getValue() + "\"");
        }
        builder.append(">");
        return builder.toString();
    }
}
// END
