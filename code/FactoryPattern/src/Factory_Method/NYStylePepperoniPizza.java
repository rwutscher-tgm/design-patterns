package Factory_Method;

import java.util.ArrayList;

public class NYStylePepperoniPizza extends Pizza {

    public NYStylePepperoniPizza() {
        this.setName("NY Style Pepperoni Pizza");
        this.setDough("Thin Crust Dough");
        this.setSauce("Marinara Sauce");

        ArrayList<String> top = new ArrayList<String>();
        top.add("Grated Reggiano Cheese");
        top.add("Sliced Pepperoni");
        top.add("Garlic");
        top.add("Onion");
        top.add("Mushrooms");
        top.add("Red Pepper");
        this.setToppings(top);
    }
}