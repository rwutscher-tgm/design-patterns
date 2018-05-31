package Factory_Method;

import java.util.ArrayList;

public class NYStyleVeggiePizza extends Pizza {

    public NYStyleVeggiePizza() {
        this.setName("NY Style Veggie Pizza");
        this.setDough("Thin Crust Dough");
        this.setSauce("Marinara Sauce");

        ArrayList<String> top = new ArrayList<String>();
        top.add("Grated Reggiano Cheese");
        top.add("Garlic");
        top.add("Onion");
        top.add("Mushrooms");
        top.add("Red Pepper");
        this.setToppings(top);
    }
}