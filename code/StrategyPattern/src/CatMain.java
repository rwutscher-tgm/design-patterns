public class CatMain {
    public static void main(String[] args){
        Cat lion = new Lion();
        lion.display();
        lion.performHunt();
        lion.makeSound();

        System.out.println();

        Cat housecat = new HouseCat();
        housecat.display();
        housecat.performHunt();
        System.out.println("break leg");
        housecat.setHuntingbehavior(new NoHunt());
        housecat.performHunt();
        housecat.makeSound();
    }
}
