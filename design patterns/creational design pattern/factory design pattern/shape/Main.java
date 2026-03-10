

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ShapeFactory shapeFactory=new ShapeFactory();
        Shape shape1=shapeFactory.getShape("rectangle",4,5);
        Shape shape2= shapeFactory.getShape("square",10);
        System.out.println("area of shape one is " + shape1.getArea());
        System.out.println("area of shape two is"+shape2.getArea());
        System.out.println("parameter if shape one is "+shape1.getPerimeter());
        System.out.println("parameter if shape two is "+shape2.getPerimeter());
    }
}