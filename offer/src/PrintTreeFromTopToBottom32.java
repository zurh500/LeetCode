import java.util.ArrayList;

public class PrintTreeFromTopToBottom32 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        //二叉树的程序遍历 使用队列来完成
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<TreeNode> q = new ArrayList<>(); //存放遍历顺序
        if(root == null){
            return list;
        }
        q.add(root);//先添加根节点
        while(q.size() != 0){ //队列不为空
            TreeNode node = q.remove(0);
            if(node.left != null)
                q.add(node.left);
            if(node.right != null)
                q.add(node.right);
            list.add(node.val);
        }
        return list;
    }
}
