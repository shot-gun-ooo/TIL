package anonymous;

import lombok.*;
/*
 * Lombok
 *
 * @Data
 * - getter + setter + toString + equals + hashCode + RequiredArgsConstructor 포함
 *
 * @Getter
 * - 모든 필드의 getter 생성
 *
 * @Setter
 * - 모든 필드의 setter 생성 (값 변경 가능)
 * - 필드에만 붙이면 해당 필드만 setter 생성
 *
 * @NoArgsConstructor
 * - 기본 생성자 생성 (new Member())
 *
 * @AllArgsConstructor
 * - 모든 필드 생성자 생성 (new Member(id, name, age))
 *
 * @RequiredArgsConstructor
 * - final + @NonNull 필드만 생성자에 포함
 *
 * @Builder
 * - builder 패턴 생성
 *   → Member.builder().id(...).name(...).age(...).build()
 *
 * - 사용하는 경우
 *   → 필드가 많을 때 (순서 헷갈림 방지)
 *   → 일부 값만 선택적으로 넣고 싶을 때
 *   → 가독성 좋게 객체 생성할 때
 *
 * - 장점
 *   -> 생성자 파라미터 순서 신경 안 써도 됨
 *   ->어떤 값 넣는지 코드에서 명확하게 보임
 *
 * - 안 써도 되는 경우
 *  -> 필드가 2~3개로 단순한 경우 (생성자가 더 간단)
 *
 * @NonNull
 * - null 들어오면 NullPointerException 발생 코드 자동 생성
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@Getter // 전체 getter

public class Member {

    private String id;

    @NonNull
    private String name;
    /*
     * 특정 필드만 setter 허용
     */
    @Setter
    private int age;
}
