package ch08.sec04;

public class RemoteControlExample {
    public static void main(String[] args) {
        RemoteControl rc;

        rc = new Television();
        rc.turnOn();
        rc.setVolume(5);
        rc.turnOff();
        rc = new ch08.sec08.Audio();
        rc.turnOn();
        rc.setVolume(5);
        rc.turnOff();
    }
}
