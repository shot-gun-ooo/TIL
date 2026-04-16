package test;

public class Shop {
    public static void main(String[] args) {

        Oder loginUser = Oder.USER;
        Status status = Status.ORDERED;

        String access = switch (loginUser) {
            case ADMIN -> "회원관리, 상품관리";
            case USER -> "상품조회";
            case GUEST -> "로그인 필요";
        };

        System.out.println("접근 가능 권한: " + access);
        System.out.println("\n--- 주문 취소 시도 ---");

        switch (loginUser) {
            case GUEST -> {
                System.out.println("로그인이 필요한 서비스입니다.");
            }
            case USER -> {

                if (status == Status.ORDERED || status == Status.PAID) {
                    status = Status.CANCELLED;
                    System.out.println("주문이 취소되었습니다.");
                    System.out.println("변경된 주문 상태 : " + status);
                } else {
                    System.out.println("배송 중이어서 취소가 불가능합니다.");
                }
            }
            case ADMIN -> {

                status = Status.CANCELLED;
                System.out.println("관리자 권한으로 강제 취소되었습니다.");
                System.out.println("변경된 주문 상태 : " + status);
            }
        }
    }
}