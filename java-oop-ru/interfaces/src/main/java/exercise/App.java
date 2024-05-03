package exercise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
class App {
    public static void main(String[] args) {
        List<Home> apartments = new ArrayList<>(List.of(
                new Flat(41, 3, 10),
                new Cottage(125.5, 2),
                new Flat(80, 10, 2),
                new Cottage(150, 3)
        ));

        List<String> result = App.buildApartmentsList(apartments, 3);
        System.out.println(result);

        CharSequence text = new ReversedSequence("abcdef");
        System.out.println(text.toString()); // "fedcba"
        System.out.println(text.charAt(1)); // 'e'
        System.out.println(text.length()); // 6
        System.out.println(text.subSequence(1, 4).toString()); // "edc"
    }

    public static List<String> buildApartmentsList (List<Home> homeList, int count) {
        List<String> result = new ArrayList<>();
        homeList.sort(Comparator.comparing(Home::getArea));
        if (count > homeList.size()) {
            return homeList.stream().map(Home::toString).collect(Collectors.toList());
        }
        for (int i = 0; i < count; i++) {
            result.add(homeList.get(i).toString());
        }
        return result;
    }
}
// END
