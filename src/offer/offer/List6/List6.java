package offer.offer.List6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 */
public class List6 {
    public static ArrayList<Integer> arrlist = null;
    public static ListNode head;
/*    private static ListNode head;
    static{
        for (int i = 0; i < 5; i++) {
            head = new ListNode(i);
            head.next = head;
            System.out.print(head + "->");
        }
    }*/


    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        //正常遍历
        /*ArrayList<Integer> list = new ArrayList<>();
        while (listNode != null) {
            list.add(listNode.val);
            listNode = listNode.next;
        }
        return list;*/
        /*
        要想反向遍历，链表的尾最后加进来，第一个出去
        “后进先出”是栈的思想，所以遍历完一个节点就压栈，最后弹栈就是反的顺序了
         */
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()) { //如果栈不为空 需调用栈的判断是否为空的方法
            list.add(stack.pop());
        }
        return list;
    }



    public static void main(String[] args){
        for (int i = 0; i < 5; i++) {
            head = new ListNode(i);
            head.next = head;
            ArrayList<Integer> list = printListFromTailToHead(head);
            System.out.print(head + "->");
        }
    }

    public static ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        /*
        使用递归
         */
        ArrayList<Integer> list = new ArrayList<>();
        while (listNode != null) {
            if(listNode.next != null)
                printListFromTailToHead2(listNode);
            list.add(listNode.val);
        }
        return list;

    }
}
