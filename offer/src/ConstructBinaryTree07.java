public class ConstructBinaryTree07 {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode node = reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
        return node;
    }
    //设置私有的函数 重建二叉树
    //参数分别为 前序遍历头尾，中序遍历头和尾
    private TreeNode reConstructBinaryTree(int[] pre,int startpre,int endpre,int[] in,int startin,int endin){
        if(startpre > endpre || startin > endin){
            return null; //健壮性判断
        }
        TreeNode node = new TreeNode(pre[startpre]); //前序遍历的第一个节点肯定是根节点 找到根节点
        for(int i = startin; i <= endin; i++){ //遍历中序遍历结果  找到根节点 划分左右子树
            if(in[i] == node.val){
                //递归重建左右子树 前序遍历左子树到的起止，中序遍历左子树的起止（右同理）
                //startpre+1-(i-1-startin) = startpre-startin+1
                node.left = reConstructBinaryTree(pre,startpre+1,startpre-startin+i,in,startin,i-1);
                node.right = reConstructBinaryTree(pre,startpre-startin+i+1,endpre,in,i+1,endin);
                break;
            }
        }
        return node;
    }
}
