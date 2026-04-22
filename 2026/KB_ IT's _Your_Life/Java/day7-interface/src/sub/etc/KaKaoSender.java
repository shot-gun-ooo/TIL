package sub.etc;

public class KaKaoSender implements Notifier{
    @Override
    public void send(String message) {
        System.out.println("카독 발송 " + message);

    }
}
