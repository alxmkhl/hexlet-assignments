package exercise;

// BEGIN
public class App {
    public static void main(String[] args) throws NegativeRadiusException {


//        Point point = new Point(3, 4);
//        Circle circle = new Circle(point, 1);
//        System.out.println(circle.getRadius()); // 1
//        System.out.println(circle.getSquare()); // 3.1415...

        Point point = new Point(5, 7);
        Circle circle = new Circle(point, 4);
        App.printSquare(circle);
        // => "50"
        // => "Вычисление окончено"

//        Circle circle1 = new Circle(point, -2);
//        System.out.println(App.printSquare(circle1));
       //  => "Не удалось посчитать площадь"
        //  => "Вычисление окончено"
    }

    public static void printSquare(Circle circle) {
        try {
            System.out.println(Math.round(circle.getSquare()));
        } catch (NegativeRadiusException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("Вычисление окончено");
    }

}
// END
