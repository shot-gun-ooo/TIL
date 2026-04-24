package test;

import java.sql.SQLOutput;
import java.time.DayOfWeek;

enum Week { // 파일 하나에 클래스가 두 개일 땐 public을 하나만 붙일 수 있어요
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

public class EnumTest {
    public static void main(String[] args) {

        // 오늘 요일을 하나 지정
        Week today = Week.WEDNESDAY;

        System.out.println("오늘은 " + today + "입니다.");

        // switch문으로 사용하기 (가장 많이 쓰이는 방식)
        switch(today) {
            case MONDAY:
                System.out.println("월요일은 힘들어요...");
                break;
            case WEDNESDAY:
                System.out.println("수요일! 벌써 주 중반이네요~");
                break;
            case FRIDAY:
                System.out.println("불금입니다!!");
                break;
            case SATURDAY:
            case SUNDAY:
                System.out.println("주말이예요~ 행복한 시간!");
                break;
            default:
                System.out.println("평일입니다.");
        }

    if(today== Week.WEDNESDAY){
        System.out.println("수요알");
        System.out.println(today.name());
        System.out.println(today.ordinal());
    }
    Week[] weeks = Week.values();
    for(Week w: weeks){
        System.out.println(w.ordinal() + " " + w.name());
    }

        /*
         * ===============================
         * Array12 - 열거 타입 (enum)
         * ===============================
         *
         * 열거 타입이란?
         * - 한정된 값(상수)만 가질 수 있는 특별한 타입
         * - 요일, 계절, 방향처럼 정해진 값의 집합을 표현할 때 사용한다
         * - 숫자(int)로 관리하면 실수하기 쉬운 상황을 안전하게 처리할 수 있다
         *   String 으로 비교하면 오타 위험이 있지만
         *   enum 은 컴파일 시점에 오류를 잡아준다 (타입 안정성)
         * 선언 형식
         * public enum 열거타입명 { 상수1, 상수2, ... }
         *
         * 관례상 상수명은 모두 대문자로 작성한다
         */
    }
}
