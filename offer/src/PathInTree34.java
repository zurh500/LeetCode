import java.util.ArrayList;
import java.util.Stack;

/*
输入一颗二叉树的跟节点和一个整数，
打印出二叉树中结点值的和为输入整数的所有路径。
路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
(注意: 在返回值的list中，数组长度大的数组靠前)

从根节点开始向下查找 就是前序遍历
向下查找需要保存路径保存到栈中
查找到叶子节点并且路径值满足target 添加节点值
查找完一个节点的相应叶子节点要将这些节点弹栈

*/
public class PathInTree34 {
    //创建一个集合存放返回的路径
    ArrayList<ArrayList<Integer>> list = new ArrayList<>(); //存放完整路径节点
    ArrayList<Integer> nodeList = new ArrayList<>(); //存放路径节点
    //Stack<Integer> stack = new Stack<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if(root == null) //当树为空的时候
            return list;
        //stack.push(root.val); //将根节点入栈
        nodeList.add(root.val);
        target -= root.val; //累减
        //和满足目标值，并且该节点的左右孩子都为空说明为叶子节点
        if(target == 0 && root.left == null && root.right == null){
            list.add(new ArrayList<Integer>(nodeList));
        }
        //不满足条件 继续向下查找 则递归 查左右节点
        FindPath(root.left,target);
        FindPath(root.right,target);
        //若执行到这说明已经是叶子节点了，那么就像叶子节点出栈
        //stack.pop(); //执行一次就行，因为每次递归针对一个点，出栈节点就行
        nodeList.remove(nodeList.size()-1); // 移除最后一项
        return list;
    }
}
