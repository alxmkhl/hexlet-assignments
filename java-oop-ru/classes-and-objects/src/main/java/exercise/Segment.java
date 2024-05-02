package exercise;

// BEGIN
class Segment {
    private Point x;
    private Point y;

    public Segment(Point x, Point y) {
        this.x = x;
        this.y = y;
    }

    public Point getBeginPoint() {
        return x;
    }

    public Point getEndPoint() {
        return y;
    }

    public Point getMidPoint() {
        return new Point((x.getX() + y.getX()) / 2, (x.getY() + y.getY()) / 2);
    }

    public static void main(String[] args) {
        Point point1 = new Point(4, 3);
        Point point2 = new Point(6, 1);
        Segment segment = new Segment(point1, point2);
        Point midPoint = segment.getMidPoint();
        System.out.println(midPoint.getX()); // 5
        System.out.println(midPoint.getY()); // 2
    }
}
// END
