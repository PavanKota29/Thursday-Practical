package mypack;

/*"Create an abstract class called "Shape" with an abstract method called "calculateArea". 
Create two subclasses called "Circle" and "Rectangle" that inherit from Shape and implement
 the "calculateArea" method. Create objects of both the Circle and Rectangle classes and call
 their respective "calculateArea" methods*/

abstract class Shape {//abstract class and parent classs
    public abstract double calculateArea();//abstract method
}

class Circle extends Shape {//child class
    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double calculateArea() {//defining the boday for abstract method
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {//child class
    double width;
    double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }


    public double calculateArea() {//defining the boday for abstract method
        return width * height;
    }
}


public class UseAbstract {
    public static void main(String[] args) {
        Circle circle = new Circle(5.0);//object creating 
        double circleArea = circle.calculateArea();//calling method
        System.out.println("Circle area: " + circleArea);

        Rectangle rectangle = new Rectangle(3.0, 4.0);//object creating
        double rectangleArea = rectangle.calculateArea();//calling method
        System.out.println("Rectangle area: " + rectangleArea);
    }
}

