package AliTest;

public class Ali implements Person{
    String name;
    Instrument instrument;

    public Ali(String name, Instrument instrument){
        this.name = name;
        this.instrument = instrument;
    }
    @Override
    public void walk() {
        System.out.println("Walks normally");
    }

    @Override
    public void talk() {
        System.out.println("I like guitar");
    }

    @Override
    public void talent() {
        System.out.println(this.name + " plays the " + this.instrument.name);
    }



    public static void dance(Ali ali){
        System.out.println(ali.name + " is dancing");
    }


    public static void main(String[] args){
        Instrument guitar = new Guitar("Classic Guitar");
        Instrument piano = new Piano("Piano");
        Ali ali = new Ali("Ali", guitar);
        Ali hussain = new Ali("Hussain", piano);

        ali.talk();
        ali.walk();
        ali.talent();
        System.out.println();
        dance(ali);

        System.out.println();

        hussain.talent();


    }
}
