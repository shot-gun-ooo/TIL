package parameter;

public class Run {
    public static void main(String[] args) {

        Driver driver = new Driver();
        driver.drive(new Bus());
        driver.drive(new Taxi());
    }
}
