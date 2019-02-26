package leetcode1;

import java.util.Stack;

/*
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，
判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。
 */
public class ValidParentheses20 {
    public static boolean isValid(String s) {
        /*
            利用栈的数据结构
            给定字符串 遍历
            如果满足( { [ 压栈
            否则
                出栈的第一个元素分别和和入栈的元素匹配

         */
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            //表示字符的值
            char c = s.charAt(i);
            if (c == '{' || c == '(' || c == '[') {
                stack.push(c); //压栈
            } else { //说明都是右括号
                if (stack.isEmpty()) { //判断栈是否为空
                    return false;
                }
                char topChar = stack.pop(); //出栈
                //判断有括号是否跟栈顶匹配
                if (c == ')' && topChar != '(') {
                    return false;
                }
                if (c == ']' && topChar != '[') {
                    return false;
                }
                if (c == '}' && topChar != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty(); //存在非法输入或者 字符串为空
    }
    public static void main(String[] args){
        System.out.println(isValid("{(([{}]))}"));
    }
}
