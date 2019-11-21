public class Square extends GeometricObject {
    private double x;
    private double y;
    private double lengthOneSide;

    public Square(double x, double y, double length) {
        this.x = x;
        this.y = y;
        this.lengthOneSide = length;
    }
    @Override
    public String toString() {
        return "Square - Upper left at: " + this.x + ", " + this.y + " Length of each side: " + this.lengthOneSide;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a Square.");
    }

    @Override
    public void resize(double percent) {
        this.lengthOneSide = this.lengthOneSide * percent;
    }
}
