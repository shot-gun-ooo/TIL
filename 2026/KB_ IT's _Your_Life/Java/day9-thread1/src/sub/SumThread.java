import lombok.NoArgsConstructor;

@NoArgsConstructor // 1. 어노테이션은 클래스 상단으로 이동해야 합니다.
public class SumThread extends Thread {

    private long sum;

    public long getSum() {
        return sum;
    }

    public void setSum(long sum) {
        this.sum = sum;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) { // 1부터 100까지 더하도록 범위 조정
            sum += i;

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace(); // 예외 발생 시 로그 출력
            }
        }
    } // run 메서드 닫기
} // 클래스 닫기