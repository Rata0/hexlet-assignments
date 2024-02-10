package exercise;


// BEGIN
class Circle {
    Point point;
    int radius;

    Circle(Point point, int radius) {
        this.point = point;
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }
    public double getSquare() throws NegativeRadiusException {
        if (radius < 0) {
            throw new NegativeRadiusException("Радиус не может быть меньше 0");
        }
        return Math.PI * Math.pow(radius, 2);
    }

}
// END
