import java.util.Stack;

public class TwoStackOneQueue9 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    //入队
    public void push(int node) {
        stack1.push(node);
    }
    //出队
    public int pop() throws Exception {
        if(stack2.isEmpty()){
            while (stack1.size() > 0) {
                Integer val = stack1.pop();
                stack2.push(val);
            }
        }
        if(stack2.isEmpty())
            throw new Exception("栈为空");
        return stack2.pop();
    }
    public static void main(String[] args) throws Exception {
        TwoStackOneQueue9 a = new TwoStackOneQueue9();
        for (int i = 0; i < 5; i++) {
            a.push(i);
        }
        for (int i = 0; i < 5; i++) {
            System.out.print(a.pop());
        }
    }
}
