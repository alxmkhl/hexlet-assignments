package exercise;

// BEGIN
public class LabelTag implements TagInterface {
    private String text;
    private TagInterface tagInterface;

    public LabelTag(String text, TagInterface tagInterface) {
        this.text = text;
        this.tagInterface = tagInterface;
    }

    @Override
    public String render() {
        return "<label>" + this.text + this.tagInterface.render() + "</label>";
    }
}
// END
