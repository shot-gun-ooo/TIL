package sub;

public class RemoteControlUse {
    public static void main(String[] args) {
//      RemoteControl rc = new Television();
        RemoteControl rc = new Video();
        rc.turnOn();
        rc.turnOff();
        System.out.println(RemoteControl.COMPANY);


        rc.setMute(true);

        rc = new Television();
        rc.setMute(true);


        RemoteControl.changeBattery();

        SmartTelevision2 st = new SmartTelevision2();
        RemoteControl rc4 = st;
        rc4.turnOn();
        rc4.turnOff();

        Searchable se = st;
        se.search("naver");

        MultiControl multi = st;
        multi.turnOn();
        multi.turnOff();
        multi.search("naver");
        multi.ott();

    }
}