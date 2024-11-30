package problemfive;

import problemfive.enums.PizzaSize;
import problemfive.enums.PizzaType;

public class ProblemFive {

    public static void main(String[] args) {
        Pizza pizza1 = new Pizza(PizzaSize.SMALL, PizzaType.VEGGIE,2);
        Pizza pizza2 = new Pizza(PizzaSize.MEDIUM, PizzaType.PEPPERONI,1);
        Pizza pizza3 = new Pizza(PizzaSize.LARGE, PizzaType.BBQ_CHICKEN,2);
        System.out.println(pizza1.printOrderSummary());
        System.out.println(" ");
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println(pizza2.printOrderSummary());
        System.out.println(" ");
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println(pizza3.printOrderSummary());
    }
}
