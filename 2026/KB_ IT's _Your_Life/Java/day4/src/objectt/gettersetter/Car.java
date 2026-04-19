package objectt.gettersetter;

public class Car {

    private String model;
    private boolean start;
    private int speed;
    private String color = "검정";
    private int maxSpeed = 350;

    public String getModel(){
        return model;
    }

    public void setSpeed(int speed){
        if(speed < 0 || speed>maxSpeed){
            System.out.println(speed);
            return;
        }
       this.speed = speed;
    }

    public void setColor(String color){
        this.model = model;
    }
}

