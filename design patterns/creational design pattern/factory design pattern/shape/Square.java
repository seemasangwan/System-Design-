public class Square implements Shape {
    private int side;
    public Square(int side)
    {
        this.side=side;
    }
    public int getSide()
    {
        return this.side;
    }
    public void setSide(int side)
    {
        this.side=side;
    }

    @Override
    public int getArea()
    {
        return side*side;
    }
    @Override
    public int getPerimeter()
    {
        return 4*side;
    }
}
