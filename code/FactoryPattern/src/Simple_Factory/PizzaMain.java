package Simple_Factory;

public class PizzaMain {

    public static void main(String[] args) {
        SimplePizzaFactory factory = new SimplePizzaFactory();
        PizzaStore store = new PizzaStore(factory);

        Pizza pizza = store.orderPizza("cheese");
        System.out.println();

        pizza = store.orderPizza("mistake");
        System.out.println();

        pizza = store.orderPizza("salami");
        System.out.println();
    }

}
