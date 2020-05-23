/**
 * func：
 *
 * @Author： allanQin
 * @Date: 2020/5/22 14:09
 */
public class HomeWorkAlg {

    public static void main(String[] args) {
        //链表反转
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        ListNode reverseList = reverseList(listNode);
        while (reverseList != null) {
            System.out.println(reverseList.val);
            reverseList = reverseList.next;
        }

    }

    /**
     * 反转链表
     *
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        //需要一个记录当前节点的上一个节点
        ListNode prev = null;
        //需要一个记录当前改遍历的节点
        ListNode curr = head;
        while (curr != null) {
            //提取一个中间变量来作为中间转换
            ListNode nextTemp = curr.next;
            curr.next = prev;//反过来 比如一开始1 ，那么反过来1 的下一个节点就是null
            prev = curr;//curr赋值给prev表示下一轮的上一个节点
            curr = nextTemp;//下一轮改遍历的节点
        }

        //结束后 链表已经反转过来
        return prev;
    }

    /**
     * 两两交换链表中的节点
     * 时间复杂度O(N) N表示链表的节点数量
     * 空间复杂度 O(1)
     *
     * @param head
     * @return
     */
    public static ListNode swapPairs(ListNode head) {

        ListNode dummy = new ListNode(-1);//记录头节点的上游
        dummy.next = head;

        ListNode prev = dummy;

        while (head != null && head.next != null) {

            ListNode firstNode = head;
            ListNode secondNode = head.next;

            //交换
            prev.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            prev = firstNode;
            head = firstNode.next;//下一次迭代
        }

        return dummy.next;

    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
