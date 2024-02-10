package exercise;

import java.util.Map;

// BEGIN
public class SingleTag extends Tag {
    public SingleTag(String tagName, Map<String, String> attributes) {
        this.tagName = tagName;
        this.attributes = attributes;
    }

    @Override
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
