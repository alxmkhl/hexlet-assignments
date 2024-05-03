package exercise;

// BEGIN
public class Cottage implements Home {
    private double area;
    private int floorCount;

    public Cottage(double area, int floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }

    @Override
    public Double getArea() {
        return this.area;
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
        return this.floorCount + " этажный коттедж площадью " + this.getArea() + " метров";
    }
}
// END
