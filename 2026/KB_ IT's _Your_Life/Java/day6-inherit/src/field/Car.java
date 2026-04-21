package field;

public class Car {
    private  int num;
    private  String str;
    private Tire tire;


    public void setTire(Tire tire) {
        this.tire = tire;
    }

    public void run(){
        tire.roll();
    }
}
