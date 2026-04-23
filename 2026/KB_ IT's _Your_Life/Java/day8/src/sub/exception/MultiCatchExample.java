package com.kb.chap11n.makeclass.b_multicatch;

// ===============================
// [Chapter 11] 다중 catch / 멀티 catch
// ===============================
//
// 공식 문서:
//   https://docs.oracle.com/javase/tutorial/essential/exceptions/catch.html
//
// ===============================
// 다중 catch
// ===============================
//
//   try 블록에서 발생할 수 있는 예외 종류가 여러 가지일 때
//   catch 블록을 여러 개 작성한다.
//   위에서부터 순서대로 확인하며 해당하는 catch 블록 하나만 실행된다.
//
//   try {
//       ...
//   } catch (예외클래스1 e) {
//       ...
//   } catch (예외클래스2 e) {
//       ...
//   }
//
// ===============================
// 상위 예외 클래스 순서 주의
// ===============================
//
//   상위 예외 클래스(부모)는 반드시 catch 블록의 아래쪽에 작성해야 한다.
//
//   잘못된 순서 예시 (컴파일 에러):
//     catch (Exception e) { }                    ← 상위 클래스가 위에 있으면
//     catch (ArrayIndexOutOfBoundsException e) { } ← 이 블록은 절대 실행 안 됨
//
//   이유:
//     Exception 은 모든 예외의 부모이므로
//     위에 있으면 모든 예외를 가로챈다.
//     → 컴파일 에러: "Exception has already been caught"
//
//   올바른 순서:
//     구체적인 예외(자식) 먼저 → 범용적인 예외(부모) 나중
//
// ===============================
// 멀티 catch (Java 7+)
// ===============================
//
//   처리 방식이 동일한 예외 여러 개를
//   하나의 catch 블록에서 | 기호로 묶어 처리한다.
//
//   문법:
//     catch (예외클래스1 | 예외클래스2 e) { }
//
//   주의:
//     멀티 catch 에서 e 는 묵시적으로 final 이다.
//     catch 블록 안에서 e 에 다른 값을 대입할 수 없다.
//
// ===============================
public class MultiCatchExample {

    public static void main(String[] args) {

        // ===============================
        // 1. 다중 catch (sec03/exam01)
        // ===============================
        // 발생 가능한 예외:
        //   i=1 일 때 : "1oo" → NumberFormatException
        //   i=2 일 때 : array[2] 초과 → ArrayIndexOutOfBoundsException
        System.out.println("=== 1. 다중 catch ===");

        String[] array = {"100", "1oo"};

        for (int i = 0; i <= array.length; i++) {
            try {
                int value = Integer.parseInt(array[i]);
                System.out.println("array[" + i + "]: " + value);

            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("배열 인덱스 초과: " + e.getMessage());

            } catch (NumberFormatException e) {
                System.out.println("숫자 변환 불가: " + e.getMessage());
            }
        }

        // ===============================
        // 2. 상위 예외 순서 (sec03/exam02)
        // ===============================
        // 구체적인 예외 먼저, 상위 예외(Exception)는 아래쪽에 작성
        System.out.println("\n=== 2. 상위 예외 순서 ===");

        for (int i = 0; i <= array.length; i++) {
            try {
                int value = Integer.parseInt(array[i]);
                System.out.println("array[" + i + "]: " + value);

            } catch (ArrayIndexOutOfBoundsException e) {
                // 구체적인 예외 먼저 처리
                System.out.println("배열 인덱스 초과: " + e.getMessage());

            } catch (Exception e) {
                // 상위 예외 클래스는 아래쪽에 작성해야 한다
                System.out.println("실행에 문제가 있습니다.");
            }
        }

        // ===============================
        // 3. 멀티 catch (sec03/exam03)
        // ===============================
        // NullPointerException 과 NumberFormatException 을 | 로 묶어 처리
        System.out.println("\n=== 3. 멀티 catch ===");

        String[] array2 = {"100", "1oo", null, "200"};

        for (int i = 0; i <= array2.length; i++) {
            try {
                int value = Integer.parseInt(array2[i]);
                System.out.println("array[" + i + "]: " + value);

            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("배열 인덱스 초과: " + e.getMessage());

            } catch (NullPointerException | NumberFormatException e) {
                // 두 예외를 | 로 묶어 동일하게 처리 - e 는 묵시적으로 final
                System.out.println("데이터에 문제가 있음: " + e.getMessage());
            }
        }
    }
}
