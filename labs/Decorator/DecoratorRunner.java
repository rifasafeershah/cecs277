public class DecoratorRunner {
    public static void main(String[] args) {
        //creates two new geometric objects with decorators
        GeometricObject c1 = new LineWeightDecorator (new FillColorDecorator
                (new Circle (3, 4, 5), Color.BLUE), LineWeight.LIGHT);
        GeometricObject c2 = new LineWeightDecorator (new FillColorDecorator
                (new Square (4, 5, 3), Color.BLACK), LineWeight.MEDIUM);
        //wraps the second object with a line color decorator
        c2 = new LineColorDecorator(c2, Color.GREEN);
        c1.draw();
        System.out.println(c1);
        c2.draw();
        System.out.println(c2);
    }
}
