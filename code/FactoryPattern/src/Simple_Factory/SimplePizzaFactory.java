package Simple_Factory;

public class SimplePizzaFactory {

    public Pizza createPizza(String type){
        Pizza pizza = null;

        if(type.equals("cheese")){
            pizza = new CheesePizza();
        } else if(type.equals("salami")){
            pizza = new SalamiPizza();
        } else if(type.equals("mistake")){
            pizza = new PineapplePizza();
        }

        return pizza;
    }

}
