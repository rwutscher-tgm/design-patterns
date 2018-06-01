package decorator_pattern;

public class CoffeeShop {
    public static void main(String[] args){
        Beverage housblendDoubleMocha = new HouseBlend();
        housblendDoubleMocha = new Mocha(housblendDoubleMocha);
        housblendDoubleMocha = new Mocha(housblendDoubleMocha);

        System.out.println(housblendDoubleMocha.getDescription());

        Beverage espressomochawhip = new Espresso();
        espressomochawhip = new Mocha(espressomochawhip);
        espressomochawhip = new Whip(espressomochawhip);

        System.out.println(espressomochawhip.getDescription());

    }
}
