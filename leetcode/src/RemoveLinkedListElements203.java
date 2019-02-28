/*
删除链表中等于给定值 val 的所有节点。
 */
public class RemoveLinkedListElements203<string> {
    public static ListNode removeElements(ListNode head, int val) {
        //先判断头结点是要删除元素  用while是如果删完后第二个头结点依旧要删除
        while(head != null && head.val == val){
            ListNode delNode = head; //头结点为要删除的节点
            head = head.next; //绕过delNode
            delNode.next = null; //要只除去指针
        }
        if(head == null){
            return null;
        }
        //其他节点删除（除头结点）
        ListNode preNode = head; //之前的节点
        while(preNode.next != null){   //要判断的是preNode的下一个
            if(preNode.next.val == val){  //当前节点满足
                ListNode delNode = preNode.next;  //指向要删除的节点
                preNode.next = delNode.next;  //绕过要删除的节点
                delNode.next = null;
            } else {
                preNode = preNode.next;  //向后遍历
            }
        }
        return head;
    }
    //简化版
    public static ListNode removeElements2(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null) {
            return null;
        }
        ListNode preNode = head;
        while (preNode.next != null) {
            if (preNode.next.val == val) {
                preNode.next = preNode.next.next;
            } else {
                preNode = preNode.next;
            }
        }
        return head;
    }
    //使用虚拟头结点
    public static ListNode removeElements3(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode preNode = dummyHead; //使用虚拟头结点就不用单独判断头了
        while (preNode.next != null) {
            if (preNode.next.val == val) {
                preNode.next = preNode.next.next;
            } else {
                preNode = preNode.next;
            }
        }
        return dummyHead.next;
    }
    //递归
    public static ListNode removeElements4(ListNode head, int val) {
        if (head == null){
            return head;
        }
//        ListNode res = removeElements4(head.next, val); //使用递归
        head.next = removeElements4(head.next, val); //使用递归
//        if (head.val == val) {
//            return res;
//        } else {
//            head.next = res;
//            return head;
//        }
//        head.next = res;
        return head.val == val ? head.next : head;

    }
    public static void main(String[] args){
//        ListNode ln = new ListNode(1);
//        ln.next = new ListNode(2);
//        ln.next.next = new ListNode(3);
//        ln.next.next.next = new ListNode(4);
        int[] arr = {1, 2, 3, 5, 8, 9};
        System.out.println(removeElements(new ListNode(arr),3));
//        removeElements(new ListNode(arr),3);
//        System.out.println(printLinkedList(ln));
    }
    //打印链表
    public static String printLinkedList(ListNode ln){
        StringBuilder sb = new StringBuilder("[");
        while(ln != null){
            if (ln.next == null) {
                sb.append(ln + "]");
            } else {
                sb.append(ln + ",");
            }
            ln = ln.next;
        }
        return sb.toString();
    }
}
