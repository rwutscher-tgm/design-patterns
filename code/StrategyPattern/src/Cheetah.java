public class Cheetah extends Cat {

    public Cheetah() {
        huntingbehavior = new HuntFast();
        soundbehavior = new Roar();
    }

    @Override
    public void display() {
        System.out.println("Cheetah");
    }

}
