package AliTest;

public class Guitar extends Instrument{


    public Guitar(String name) {
        super(name);
    }

    @Override
    public void play() {
        System.out.println("ttrrrrang");
    }



    public static void main(String[] args){

        Guitar classicGuitar = new Guitar("Classic Guitar");

        classicGuitar.play();

    }
}
