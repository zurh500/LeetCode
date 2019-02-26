public class ReverseList24 {
    /*
    输入一个链表，反转链表后，输出新链表的表头。
     */
    public static ListNode ReverseList(ListNode head) {
        /*
            需要保存三个指针信息，当前、前一项、后一项
            后一项的需要先保存起来，而前一项和当前项进行指针反转
         */
        if (head == null) { //若链表为空
            return null;
        }
        if (head.next == null) { //若链表只有一个节点
            return head;
        }
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next; //把后一项暂存起来
            head.next = pre; //反转指针
            pre = head; //将两个指针向后移动
            head = next;
        }
        return pre; //输出新链表头  当head为null时，pre就是最后一项
    }
    public static void print(ListNode listNode){
        /*
        该函数不能起到遍历链表的作用，因为改了链表结构
         */
        while (listNode != null) {
            System.out.print(listNode + "->");
            listNode = listNode.next;
        }
    }
    public static void main(String[] args){
        ListNode l1 = new ListNode(0);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(2);
        l1.next.next.next = new ListNode(3);
        l1.next.next.next.next = new ListNode(4);


        System.out.println("反转后的链表头结点是：" + ReverseList(l1));
    }
}
