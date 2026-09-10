import java.util.Scanner;

// Step 1: Define the interface
interface Polygon {
    double area();
    double perimeter();
}

// Step 2: Implement a base class for a specific shape
class Quadrilateral implements Polygon {
    // What attributes do all quadrilaterals have?
    // ...
    protected double length;
    protected double width;

    public Quadrilateral(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double area() {
        // To be implemented by subclasses
        return 0;
    }

    @Override
    public double perimeter() {
        // To be implemented by subclasses
        return 0;
    }
}

// Step 3: Create a subclass using inheritance
class Rectangle extends Quadrilateral {
    public Rectangle(double length, double width) {
        super(length, width);
    }

    @Override
    public double area() {
        return length * width;
    }

    // You implement the perimeter method...
    @Override
    public double perimeter() {
        return 2 * (length + width);
    }
}

// Step 4: Create a more specific subclass
class Square extends Rectangle {
    public Square(double side) {
        // How do you call the Rectangle constructor from here?
        super(side, side);
    }
}

class Triangle implements Polygon {
    protected double height;
    protected double base;

    public Triangle(double height, double base) {
        this.height = height;
        this.base = base;
    }

    @Override
    public double area() {
        return (base * height) / 2;
    }

    @Override
    public double perimeter() {
        return 0;
    }
}


class IsoscelesTriangle extends Triangle {
    public IsoscelesTriangle(double height, double base) {
        super(height, base);
    }

    @Override
    public double perimeter() {
        double a = base/2;
        double c = Math.sqrt((a*a) + (height*height));

        return base + (2 * c);
    }

    @Override
    public double area() {
        return (base * height) / 2;
    }
}

class EquilateralTriangle extends Triangle {
    private double side;

    public EquilateralTriangle(double side) {
        super(side, side);
        this.side = side;
    }

    @Override
    public double perimeter() {
        return side * 3;
    }

    @Override
    public double area() {
        return (Math.sqrt(3) / 4) * side * side;
    }
}

//More than 4 Sides
class Above4SidesPoly implements Polygon {
    protected double sideLength;
    protected double apothem;
    protected double sideCount;
    protected double perimeter;

    public Above4SidesPoly(double sideLength, double sideCount) {
        this.sideLength = sideLength;
        this.sideCount = sideCount;
        this.apothem = sideLength / (2.0 * Math.tan(Math.toRadians(180.0/sideCount)));
        this.perimeter = sideLength * sideCount;
    }

    @Override
    public double perimeter() {
        return perimeter;
    }

    @Override
    public double area() {
        return (perimeter()) * apothem / 2;
    }
}

class Pentagon extends Above4SidesPoly {
    public Pentagon(double sideLength, double sideCount) {
        super(sideLength, sideCount);
    }

    public double perimeter() {
        return super.perimeter();
    }

    @Override
    public double area() {
        return super.area();
    }
}

class Hexagon extends Above4SidesPoly {
    public Hexagon(double sideLength, double sideCount) {
        super(sideLength, sideCount);
    }

    public double perimeter() {
        return super.perimeter();
    }

    @Override
    public double area() {
        return super.area();
    }
}

class Octagon extends Above4SidesPoly {
    public Octagon(double sideLength, double sideCount) {
        super(sideLength, sideCount);
    }

    public double perimeter() {
        return super.perimeter();
    }

    @Override
    public double area() {
        return super.area();
    }
}

// Main class for user interface
public class PolygonCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Create a polygon (Isosceles Triangle, Equilateral Triangle, Rectangle, Square, Pentagon, Hexagon, Octagon):");
        String userPolygon = scanner.nextLine().trim();


        if (userPolygon.equalsIgnoreCase("Square")) {
            System.out.print("Enter side length: ");
            Polygon p = new Square(scanner.nextDouble());

            System.out.println("Area: " + p.area());
            System.out.println("Perimeter: " + p.perimeter());
        //Rectangle
        } else if (userPolygon.equalsIgnoreCase("Rectangle")) {
            System.out.print("Length: ");
            double length = scanner.nextDouble();
            System.out.print("Width: ");
            double width = scanner.nextDouble();

            Polygon p = new Rectangle(length, width);
            System.out.println("Area: " + p.area());
            System.out.println("Perimeter: " + p.perimeter());
        //Iso Triangle
        } else if (userPolygon.equalsIgnoreCase("Isosceles Triangle")) {
            System.out.print("Height: ");
            double height = scanner.nextDouble();
            System.out.print("Base: ");
            double base = scanner.nextDouble();

            Polygon p = new IsoscelesTriangle(height, base);
            System.out.println("Area: " + p.area());
            System.out.println("Perimeter: " + p.perimeter());
        //Equi Triangle
        } else if (userPolygon.equalsIgnoreCase("Equilateral Triangle")) {
            System.out.print("Side length: ");
            double side = scanner.nextDouble();

            Polygon p = new EquilateralTriangle(side);
            System.out.println("Area: " + p.area());
            System.out.println("Perimeter: " + p.perimeter());
        } else if (userPolygon.equalsIgnoreCase("Pentagon")) {
            System.out.print("Enter side length: ");
            double sideLength = scanner.nextDouble();

            Polygon p = new Pentagon(sideLength, 5);
            System.out.println("Area: " + p.area());
            System.out.println("Perimeter: " + p.perimeter());
        } else if (userPolygon.equalsIgnoreCase("Hexagon")) {
            System.out.print("Enter side length: ");
            double sideLength = scanner.nextDouble();

            Polygon p = new Hexagon(sideLength, 6.0);
            System.out.println("Area: " + p.area());
            System.out.println("Perimeter: " + p.perimeter());
        } else if (userPolygon.equalsIgnoreCase("Octagon")) {
            System.out.print("Enter side length: ");
            double sideLength = scanner.nextDouble();

            Polygon p = new Octagon(sideLength, 8.0);
            System.out.println("Area: " + p.area());
            System.out.println("Perimeter: " + p.perimeter());
        } else {
            System.out.println("Unsupported polygon type.");
        }

        scanner.close();
    }
}