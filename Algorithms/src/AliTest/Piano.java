package AliTest;

public class Piano extends Instrument{
    public Piano(String name) {
        super(name);
    }

    @Override
    public void play() {
        System.out.println("Dunn dunn dunnnnn dunnnnnnn");
    }
}
