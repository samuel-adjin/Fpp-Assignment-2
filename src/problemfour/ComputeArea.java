package problemfour;
import java.util.Scanner;
public class ComputeArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("Enter C for Circle");
            System.out.println("Enter R for Rectangle");
            System.out.println("Enter T for Triangle");

            String choice = scanner.nextLine().toUpperCase();

            switch (choice) {
                case "C":
                    System.out.print("Enter the radius  = ");
                    double radius = scanner.nextDouble();
                    Circle cir= new Circle(radius);
                    System.out.printf("The circle area is: %.4f%n", cir.computeArea());
                    break;
                case "R":
                    System.out.println("Enter the width = ");
                    double width = scanner.nextDouble();
                    System.out.print("Enter the length = ");
                    double length = scanner.nextDouble();
                    Rectangle rect = new Rectangle(width, length);
                    System.out.printf("The rectangle area is: %.4f%n", rect.computeArea());
                    break;
                case "T":
                    System.out.print("Enter the base = ");
                    double base = scanner.nextDouble();
                    System.out.print("Enter the height = ");
                    double height = scanner.nextDouble();
                    Triangle tri = new Triangle(base, height);
                    System.out.printf("The triangle area is: %.4f%n", tri.computeArea());
                    break;
                default:
                    System.out.println("Invalid input. please enter  \"C, c, R, r, T, t\"");
            }

            System.out.println("Please enter (Y/y) for continue, other for exit");
            flag = scanner.next().equalsIgnoreCase("y");
            scanner.nextLine();
        }
        scanner.close();
    }
}
