public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
      val = x;
    }

    //也可以自定义一个构造函数 通过数组转成链表，当前ListNode为头结点
    ListNode(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("数组为空");
        }
        this.val = arr[0]; //当前的节点为数组的第一个元素
        ListNode cur = this;  //cur初始化为当前节点
        for (int i = 1 ; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode cur = this;
        while (cur != null) {
            sb.append(cur.val + "->");
            cur = cur.next;
        }
        sb.append("NULL");
        return sb.toString();
    }
}