package collection;

import java.util.ArrayList;
import java.util.List;

public class BoardUse {
    public static void main(String[] args) {
        List<Board> list = new ArrayList<>();
        list.add(new Board("홍", "편","jomg"));
        list.add(new Board("홍", "편","jomg"));
        list.add(new Board("홍", "편","jomg"));
        list.add(new Board("홍", "편","jomg"));
        list.add(new Board("홍", "편","jomg"));
        list.add(new Board("홍", "편","jomg"));

        System.out.println(list);
        System.out.println(list.size());
        System.out.println(list.get(0));
    }


}
