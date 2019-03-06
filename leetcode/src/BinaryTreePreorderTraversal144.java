import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal144 {
    //递归
    public List<Integer> preorderTraversal(TreeNode root) {
        //声明linkedlist集合
        List<Integer> list = new LinkedList<>();
        preOrder(root,list);
        return list;
    }
    public void preOrder(TreeNode node,List list){
        if(node == null)
            return;
        list.add(node.val);
        preOrder(node.left,list);
        preOrder(node.right,list);
    }


    //非递归
    public List<Integer> preorderTraversal2(TreeNode root) {
        //声明linkedlist集合
        List<Integer> list = new LinkedList<>();
        if(root == null)
            return list;
        Stack<TreeNode> stack = new Stack<>(); //通过入栈出栈顺序打印遍历结果
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            list.add(cur.val);
            if(cur.right != null){
                stack.push(cur.right);
            }
            if(cur.left != null){
                stack.push(cur.left); //打印通过下次循环出栈
            }
        }
        return list;
    }

}
