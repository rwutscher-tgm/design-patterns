package Simple_Factory;

import java.util.ArrayList;

public abstract class Pizza {

    public void prepare() {
        System.out.println("Preparing the pizza");
    }

    public void bake() {
        System.out.println("Baking the pizza");
    }

    public void cut() {
        System.out.println("Cutting the pizza");
    }

    public void box() {
        System.out.println("Boxing the pizza");
    }

}
