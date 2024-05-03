package exercise;

// BEGIN
public class Flat implements Home {
    private double area;
    private double balconyArea;
    private int floor;

    public Flat(double area, double balconyArea, int floor) {
        this.area = area;
        this.balconyArea = balconyArea;
        this.floor = floor;
    }

    @Override
    public Double getArea() {
        return this.area + this.balconyArea;
    }

    @Override
    public int compareTo(Home anotherHome) {
        if (this.getArea() > anotherHome.getArea()) {
            return 1;
        }
        if (this.getArea() < anotherHome.getArea()) {
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Квартира площадью " + this.getArea() + " метров на " + this.floor + " этаже";
    }
}
// END
