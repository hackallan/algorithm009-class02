import java.util.Deque;
import java.util.LinkedList;

/**
 * func：
 *
 * @Author： allanQin
 * @Date: 2020/5/21 20:40
 */
public class QueueTest {

    public static void main(String[] args) {

        old();
        System.out.println("==========================");
        newDeque();
    }

    public static void newDeque() {
        Deque<String> deque = new LinkedList<>();
        deque.addFirst("a");
        deque.addFirst("b");
        deque.addFirst("c");

        String peek = deque.peekFirst();//查看第一个当时不进行其他的操作peek
        System.out.println(peek);
        System.out.println(deque);

        while (deque.size() > 0) {
            System.out.println(deque.removeFirst());
        }

        System.out.println(deque);
    }

    public static void old() {
        Deque<String> deque = new LinkedList<>();
        deque.push("a");
        deque.push("b");
        deque.push("c");

        String peek = deque.peek();//查看第一个当时不进行其他的操作peek
        System.out.println(peek);
        System.out.println(deque);

        while (deque.size() > 0) {
            System.out.println(deque.pop());
        }

        System.out.println(deque);
    }
}
