/*
输入一个链表，输出该链表中倒数第k个结点。
 */
public class KtnNodeFromEnd22 {
    /*
        第一种想法：一共n个节点，倒数第k个节点，对应就是n-k+1的位置
        那如何知道几个节点呢，就需要先遍历一遍链表，然后算出n的值
        再次遍历一遍链表求出n-k+1处的值。但是这要遍历两次链表

        第二种想法：遍历一遍链表解决问题，那么就需要定义两个指针
        第一个指向k-1（k到末尾的距离），第二个指向头，然后同时遍历两个指针，
        遍历到尾后第二个指针指向的就是第k个结点

        但是此题要有相应的健壮性判断，要考虑以下问题：
            1、当链表节点总数小于k
            2、当输入的k为0
            3、输入的ListNode为null
     */
    public static ListNode FindKthToTail(ListNode head, int k) {
        if(head == null || k <=0)
            return null;
        ListNode pre = head;
        ListNode last = head;
        for (int i = 0; i < k -1; i++) {
            if (pre.next != null) {
                pre = pre.next;
            } else {
                return null;
            }
        }
        while (pre.next != null) {
            pre = pre.next;
            last = last.next;
        }

        return last;
    }
    public static void main(String[] args){
        ListNode l1 = new ListNode(0);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(2);
        l1.next.next.next = new ListNode(3);
        l1.next.next.next.next = new ListNode(4);

        System.out.println(FindKthToTail(l1,2));
    }
}
