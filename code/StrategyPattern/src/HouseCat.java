public class HouseCat extends Cat {

    public HouseCat() {
        huntingbehavior = new HuntStealthly();
        soundbehavior = new Meow();
    }

    @Override
    public void display() {
        System.out.println("House Cat");
    }

}
