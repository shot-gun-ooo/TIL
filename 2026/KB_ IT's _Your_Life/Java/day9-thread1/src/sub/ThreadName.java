package sub;

public class ThreadName {
    public static void main(String[] args) {
        Thread mainthread = Thread.currentThread();
        System.out.println(mainthread.getName() + "실행");

        for (int i=0;i<3;i++){
            Thread thread = new Thread(){
                @Override
                public void run(){
                    System.out.println(getName()+" start");
                }
            };

            thread.start();

            Thread chatThread = new Thread(){
                @Override
                public void run(){
                    System.out.println(getName() + "start");
                }
            };
            chatThread.setName("chat-thread");
            chatThread.start();
        }

    }
}
