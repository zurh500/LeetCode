public class ListNode {
    //单向链表
     int val; //节点的值
     ListNode next = null; //节点的指向

     ListNode(int val) {
        this.val = val;
     }

    @Override
    public String toString() {
        return String.valueOf(val);
    }
}
