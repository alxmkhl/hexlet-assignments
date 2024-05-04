package exercise;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        Tag p = new PairedTag(
                "p",
                Map.of("id", "abc"),
                "Text paragraph",
                new ArrayList<Tag>()
        );

        System.out.println(p.toString()); // <p id="abc">Text paragraph</p>

        Tag div = new PairedTag(
                "div",
                Map.of("class", "y-5"),
                "",
                List.of(
                        new SingleTag("br", Map.of("id", "s")),
                        new SingleTag("hr", Map.of("class", "a-5"))
                )
        );

        System.out.println(div.toString()); // <div class="y-5"><br id="s"><hr class="a-5"></div>


        Map<String, String> attributes2 = new LinkedHashMap<>();
        Tag hr = new SingleTag("hr", attributes2);
        String actual2 = hr.toString();
        String expected2 = "<hr>";
        System.out.println(actual2);
    }
}
