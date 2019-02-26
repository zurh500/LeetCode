/*
输入两个单调递增的链表，输出两个链表合成后的链表，
当然我们需要合成后的链表满足单调不减规则。
 */
public class MergeSortedLists25 {
    public ListNode Merge(ListNode list1,ListNode list2) {
        /*
            比较两个链表的头，较小的放入新链表的头，较大的依次存放
            在比较两个链表的第二个头，然后再比较存放，使用递归
            要判断特殊情况：
                1、链表为空
                2、第一个链表为空
                3、第二个链表为空
         */
        if (list1 == null) {
            return list2;
        } else if(list2 == null){
            return list1;
        }
        ListNode list3 = null;

        if (list1.val < list2.val) { //如果list1的链表头结点小于list2的链表头结点
            list3 = list1; //将较小的list1头结点赋给list3头
            list3.next = Merge(list1.next,list2); //利用递归 合并第一个链表的下一项与链表二
        } else {
            list3 = list2;
            list3.next = Merge(list2.next,list1);
        }
        return list3;
    }
    public static void main(String[] args){
        ListNode l1 = new ListNode(0);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(2);
        l1.next.next.next = new ListNode(3);
        l1.next.next.next.next = new ListNode(4);

        System.out.println();
    }
}
