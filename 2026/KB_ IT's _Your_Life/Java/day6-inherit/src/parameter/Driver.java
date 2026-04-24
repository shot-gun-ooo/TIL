package parameter;

public class Driver extends Vehicle {
    public void drive(Vehicle vehicle){
        vehicle.run();
        System.out.println("운전");
    }
}
