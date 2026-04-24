package test;

public class Array2 {
    public static void main(String[] args) {
        //2차원 배열
        //1차원 배열을 묶어 놓은 것
        //배열 생성 시 값을 이미 알고 있는 경우
        int[][] scores = {
                {80, 90, 96},
                {76, 88}
        };
        //배열 --> 반복문(for)
        //1차원 배열 --> for문 하나
        //2차원 배열 --> for문 둘
        System.out.println(scores[0].length);
        System.out.println(scores[0][2]);
        System.out.println(scores[1][1]);

        //2차원 인덱스 증가할 for문 하나
        //1차원 인덱스 증가할 for문 하나
        for (int i = 0; i <scores.length ; i++) {
            for (int j = 0; j <scores[i].length ; j++) {
                System.out.println(scores[i][j]);
            }
        }



    }
}
