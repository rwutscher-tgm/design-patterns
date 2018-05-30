public class StuffedAnimalCat extends Cat {

    public StuffedAnimalCat() {
        huntingbehavior = new NoHunt();
        soundbehavior = new NoSound();
    }

    @Override
    public void display() {
        System.out.println("Stuffed Animal Cat");
    }

}
