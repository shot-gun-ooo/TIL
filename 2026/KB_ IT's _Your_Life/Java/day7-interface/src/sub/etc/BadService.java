package sub.etc;

public class BadService {

    private BadSender emailSender = new BadSender();
    public void send(String message){
        emailSender.send(message);
    }

}
