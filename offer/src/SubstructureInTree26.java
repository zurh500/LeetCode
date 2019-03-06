/*
输入两棵二叉树A，B，判断B是不是A的子结构。
（ps：我们约定空树不是任意一个树的子结构）
1、先判断树1和是否包含树2的根节点，若包含则继续向下找左右节点
2、使用递归的方式
注：空指针的问题，或者树为空的问题
 */
public class SubstructureInTree26 {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean result = false;  //什么都不满足的情况
        if(root2 != null && root1 != null){ //如果根节点不为空  如果为空直接返回false
            if(root1.val == root2.val){ //如果当前两个节点的值相等，就可以继续查找以下元素是否相等了
                result = doesTree1HaveTree2(root1,root2); //返回result 是否满足最后统一返回  这样result值改变下面的就可以继续判断
            }
            if(!result){ //说明这两个根节点不相等 不满足即result=false
                result = HasSubtree(root1.left,root2); // 看左节点中是否包含子树 若满足返回true
            }
            if(!result){ //说明以上条件均不满足 则查看右子树中是否包含2子树
                result = HasSubtree(root1.right,root2);
            }
        }
        return result;
    }
    //判断根节点对应的子节点是否相等
    private boolean doesTree1HaveTree2(TreeNode node1,TreeNode node2){
        if(node2 == null){
            return true; //说明树二已经遍历完了
        }
        if(node1 == null){
            return false;  //说明树一已经遍历完成，但是树二还没找到
        }
        if(node1.val != node2.val){ //若两个节点有一个不满足
            return false;
        }
        //左左相比 右右相比
        return doesTree1HaveTree2(node1.left,node2.left)&&doesTree1HaveTree2(node1.right,node2.right);
    }
}
