public class LineColorDecorator extends ShapeDecorator{
    private Color FillLineColor;

    public LineColorDecorator(GeometricObject shape, Color lineColor) {
        super(shape);
        this.FillLineColor = lineColor;
    }

    @Override
    public String toString() {
        return "Fill line color: " + this.FillLineColor + " for shape: " + super.getDecoratedShape();
    }

    @Override
    public void draw() {
        System.out.println ("Drawing a shape of line color: " + this.FillLineColor);
        super.getDecoratedShape().draw();
    }

    @Override
    public void resize(double percent) {
        System.out.println ("Resizing a shape of line color: " + this.FillLineColor);
        super.getDecoratedShape().resize(percent);
    }
}
