package problemfive;

import problemfive.enums.PizzaSize;
import problemfive.enums.PizzaType;

public class Pizza {

    private PizzaSize pizzaSize;
    private PizzaType pizzaType;
    private int quantity;
    private double price;

    public Pizza(PizzaSize pizzaSize, PizzaType pizzaType, int quantity) {
        this.pizzaSize = pizzaSize;
        this.pizzaType = pizzaType;
        this.quantity = quantity;
    }

    private void calculatePrice(PizzaSize pizzaSize,PizzaType pizzaType) {
        double sizePrice;
        double typePrice;
       typePrice = switch (pizzaType) {
            case VEGGIE ->  1.0;
           case PEPPERONI, BBQ_CHICKEN ->   2.0;
           case CHEESE -> 1.5;
       };

       sizePrice = switch (pizzaSize){
           case LARGE -> 12;
           case MEDIUM -> 10;
           case SMALL -> 8;
       };
       this.price = (sizePrice+typePrice)*quantity;
    }

    public String  printOrderSummary(){
        calculatePrice(this.pizzaSize,this.pizzaType);
        final double TAX_PERCENT = 3;
        double taxRate = (TAX_PERCENT /100) * price;
        double tax = taxRate * price;
        double totalPrice = price + tax;
        return String.format("""
                Pizza Order:
                Size: %s
                Type: %s
                Qty: %d
                Price: $%.2f
                Tax: $%.2f
                Total Price: $%.2f""",pizzaSize,pizzaType,quantity,price,tax,totalPrice);

    }
}
