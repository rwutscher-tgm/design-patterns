package Simple_Factory;

public class PineapplePizza extends Pizza {

    @Override
    public void prepare() {
        System.out.println("Preparing pineapple pizza");
    }

    @Override
    public void bake() {
        System.out.println("baking pineapple pizza");
    }

    @Override
    public void cut() {
        System.out.println("cutting pineapple pizza");
    }

    @Override
    public void box() {
        System.out.println("boxing pineapple pizza");
    }
}
