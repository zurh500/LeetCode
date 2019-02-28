public class DeleteNode18 {
    /*
    在O(1)时间内删除链表节点
    给定单链表的头节点指针和一个节点指针，定义一个函数在O(1)时间内删除该节点
     */
    public static ListNode deleteNode(ListNode head,ListNode delNode) {
        /*
        正常删除节点一定要遍历到要删除的头结点，但是时间复杂度是O(n)
        要想时间复杂度为O(1)，那就需要从要删除的节点出发
        删除非尾节点：将要删除的后一项节点的值和指针都复制给del要删除的指针
            最后将next指针删除，时间复杂度是O(1)
        删除尾节点：那就需要遍历一遍链表进行正常删除操作了
            那么时间复杂度就是O(n)级别的
            那么1综合考虑时间复杂度就是[(n-1)*O(1)+O(n)]/n,结果还是O(1)
        但是这只是一个假设：要删除的节点的确在链表中，否则我们要判断被删除元素是否在链表中
        这样就要从头遍历一遍链表，这样时间复杂度就不能满足是O(1)了
         */
        return null;
    }
    /*
    在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
    例如，链表1->2->3->3->4->4->5 处理后为 1->2->5

     */
    //利用递归
    public static ListNode deleteDuplication(ListNode pHead){
        if (pHead == null || pHead.next == null) {//若链表为空或者链表之一一个节点
            return pHead; //返回该节点
        }
        if (pHead.val == pHead.next.val){ //说明此项与下一项是重复元素
            ListNode pNode = pHead.next; //将指针指向第二个重复的元素（当前项的下一项）
            //pNode为当前重复的的第一个元素 若该值等于第一个值 一直向下找到都重复的值
            while (pNode != null && pNode.val == pHead.val) {
                pNode = pNode.next;
            }
            return deleteDuplication(pNode); //从第一个不相同的值开始递归删除操作
        } else { //此项和下一项不是相同元素
            pHead.next = deleteDuplication(pHead.next); //从该项的下一项开始向后递归删除重复元素
            return pHead;
        }
    }
    //利用非递归
    public static ListNode deleteDuplication1(ListNode pHead){

        ListNode dummyNode = new ListNode(-1); //设置虚拟头结点
        dummyNode.next = pHead;
        ListNode cur = pHead; //当前节点
        ListNode lastNode = dummyNode;
        if (cur == null || cur.next == null) {
            return cur;
        }
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) { //如果当前节点和下一节点为相同节点
                int val = cur.val; //将当前节点的值保存起来
                while (cur != null && cur.val == val) { //向下一直找到相同的节点
                    cur = cur.next;
                }
                lastNode.next = cur;
            } else { //没有重复元素
                lastNode = cur;
                cur = cur.next;
            }
        }
        return dummyNode.next;
    }
    public static void main(String[] args){
        int[] arr = {1,2,3,3,4,4,5};
        System.out.println(deleteDuplication1(new ListNode(arr)));
    }
}
