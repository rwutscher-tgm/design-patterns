package Factory_Method;

import java.util.ArrayList;

public class ChicagoStylePepperoniPizza extends Pizza {
    public ChicagoStylePepperoniPizza() {
        this.setName("Chicago Style Pepperoni Pizza");
        this.setDough("Extra Thick Crust Dough");
        this.setSauce("Plum Tomato Sauce");

        ArrayList<String> top = new ArrayList<String>();
        top.add("Shredded Mozzarella Cheese");
        top.add("Black Olives");
        top.add("Spinach");
        top.add("Eggplant");
        top.add("Sliced Pepperoni");
        this.setToppings(top);
    }

    public void cut() {
        System.out.println("Cutting the pizza into square slices");
    }
}