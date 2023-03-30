public class Rectangle {//class declaration
    double length;//data member
    double breadth;//

    public Rectangle(double length, double breadth) {//Constructor
        this.length = length;//Values assigning
        this.breadth = breadth;
    }

    public double getArea() {
        return length * breadth;//return Area
    }

    public double getPerimeter() {
        return 2 * (length + breadth);//return Perimeter
    }

    public static void main(String[] args) {
        Rectangle rect = new Rectangle(4.5, 3.2);//creating Obj of class
        System.out.println("Area: " + rect.getArea());
        System.out.println("Perimeter: " + rect.getPerimeter());
    }
}
