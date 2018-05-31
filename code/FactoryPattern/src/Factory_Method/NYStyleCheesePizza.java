package Factory_Method;

import java.util.ArrayList;

public class NYStyleCheesePizza extends Pizza {

    public NYStyleCheesePizza() {
        this.setName("NY Style Sauce and Cheese Pizza");
        this.setDough("Thin Crust Dough");
        this.setSauce("Marinara Sauce");

        ArrayList<String> top = new ArrayList<String>();
        top.add("Grated Reggiano Cheese");
        this.setToppings(top);
    }
}