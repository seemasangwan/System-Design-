/**
 * shape factory class which create object and return particular shape object
 *
 */
public class ShapeFactory {

    /**
     * shapeType : shape type which you want to create
     * return : Shape
     *
     */
    public Shape getShape(String shapeType , int... params) {

        if (shapeType == null) {
            throw new IllegalArgumentException("shape type can not be null");
        } else if (shapeType.equalsIgnoreCase("rectangle")) {
            return new Rectangle(params[0], params[1]);

        } else if (shapeType.equalsIgnoreCase("square")) {
            return new Square(params[0]);
        } else {
            throw new IllegalArgumentException("Invalid shape type which is currently not supported");
        }
    }
}
