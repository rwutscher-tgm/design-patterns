public class Lion extends Cat {

    public Lion() {
        huntingbehavior = new HuntInGroup();
        soundbehavior = new Roar();
    }

    @Override
    public void display() {
        System.out.println("Lion");
    }

}
