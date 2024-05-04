package exercise;

import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
public class Tag {

    private String tagName;

    public Tag(String tagName) {
        this.tagName = tagName;
    }

    @Override
    public String toString() {
        return "<" + this.tagName;
    }

    public String getTagName() {
        return tagName;
    }
}
// END
