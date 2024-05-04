package exercise;

import java.util.Map;

// BEGIN
public class SingleTag extends Tag {
    private Map<String, String> attr;

    public SingleTag(String tagName, Map<String, String> attr) {
        super(tagName);
        this.attr = attr;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (attr.isEmpty()) {
            return super.toString() + ">";
        }
        this.attr.forEach((key, value) -> {
            sb.append(key);
            sb.append("=");
            sb.append("\"");
            sb.append(value);
            sb.append("\"");
            sb.append(" ");

        });
        return super.toString() + " " + sb.toString().trim() + ">";

    }
}
// END
