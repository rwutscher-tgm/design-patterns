package Factory_Method;

import java.util.ArrayList;

public class ChicagoStyleCheesePizza extends Pizza {

    public ChicagoStyleCheesePizza() {
        this.setName("Chicago Style Deep Dish Cheese Pizza");
        this.setDough("Extra Thick Crust Dough");
        this.setSauce("Plum Tomato Sauce");

        ArrayList<String> top = new ArrayList<String>();
        top.add("Shredded Mozzarella Cheese");
        this.setToppings(top);
    }

    public void cut() {
        System.out.println("Cutting the pizza into square slices");
    }
}