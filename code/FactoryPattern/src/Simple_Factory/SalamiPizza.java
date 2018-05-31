package Simple_Factory;

public class SalamiPizza extends Pizza {

    @Override
    public void prepare() {
        System.out.println("Preparing salami pizza");
    }

    @Override
    public void bake() {
        System.out.println("baking salami pizza");
    }

    @Override
    public void cut() {
        System.out.println("cutting salami pizza");
    }

    @Override
    public void box() {
        System.out.println("boxing salami pizza");
    }
}
