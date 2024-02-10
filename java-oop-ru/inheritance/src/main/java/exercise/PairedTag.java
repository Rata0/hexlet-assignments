package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag {
    String body;
    List<Tag> child;

    PairedTag(String tagName, Map<String, String> attributes, String body, List<Tag> child) {
        this.tagName = tagName;
        this.attributes = attributes;
        this.body = body;
        this.child = child;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder("<" + tagName);
        for (Map.Entry<String, String> entry : attributes.entrySet()) {
            builder.append(" " + entry.getKey() + "=");
            builder.append("\"" + entry.getValue() + "\"");
        }
        builder.append(">");
        for (Tag element : child) {
            builder.append(element.toString());
        }
        builder.append(body);
        builder.append("</" + tagName + ">");
        return builder.toString();
    }
}
// END
