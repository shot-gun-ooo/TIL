package test;

public class SupermanUse2 {
    public static void main(String[] args) {
        Man superMan = new SuperMan("클라크",22,100,true);
        System.out.println(superMan);

        superMan.run();
        superMan.space();
        superMan.eat();
    }
}
