public abstract class Cat {

    HuntingBehavior huntingbehavior;
    SoundBehavior soundbehavior;

    public void setHuntingbehavior(HuntingBehavior huntingbehavior) {
        this.huntingbehavior = huntingbehavior;
    }

    public void setSoundbehavior(SoundBehavior soundbehavior) {
        this.soundbehavior = soundbehavior;
    }

    public abstract void display();

    public void performHunt(){
        huntingbehavior.hunt();
    }

    public void makeSound(){
        soundbehavior.makesound();
    }

    public void beFluffy() {
        System.out.println("All cats are fluffy!");
    }

}
