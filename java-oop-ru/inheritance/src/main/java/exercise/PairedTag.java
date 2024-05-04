package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag{
    private Map<String, String> attr;
    private String body;
    private List<Tag> singleTagList;

    public PairedTag(String tagName, Map<String, String> attr, String body, List<Tag> singleTagList) {
        super(tagName);
        this.attr = attr;
        this.body = body;
        this.singleTagList = singleTagList;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        sb.append(super.getTagName());
        sb.append(" ");
        this.attr.forEach((key, value) -> {
            sb.append(key);
            sb.append("=").append("\"");
            sb.append(value).append("\"").append(" ");
        });
        sb.deleteCharAt(sb.toString().length()-1);
        sb.append(">");
        sb.append(this.body);
        if (singleTagList.isEmpty()) {
            sb.append("</").append(super.getTagName()).append(">");
            return sb.toString();
        }
        this.singleTagList.forEach(tag -> {
            sb.append(tag.toString());
        });

        sb.append("</").append(super.getTagName()).append(">");
        return sb.toString();
    }
}
// END
