/*
输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class SequenceOfBST33 {
    /*
    Java：
    1、后序遍历，最后一个节点是根节点
    2、从头开始找，小于根节点的就是左子树
    3、从第一个不满足小于根节点一直到倒数第二个位置的就为右子树
            如果右子树中存在一个节点的值小于根节点的值，说明不满足，返回false
    若遍历完数组，没有返回false，说明该数组满足，那么就返回true
    4、将以i为分界的左右子树，进行递归操作
     */
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence.length == 0){ //如果数组为空  则不满足
            return false;
        }
        if (sequence.length == 1){ //说明数组中有一个节点
            return true; //那么就是满足 只有一个节点的树
        }
        return VerifySquenceOfBST(sequence,0,sequence.length-1);//end是数组中的最后一个索引值
    }
    public boolean VerifySquenceOfBST(int[] sequence, int start, int end){
        if (start >= end){ //说明遍历完数组了 没返回false就说明满足
            return true;
        }
        int root = sequence[end]; //得到根节点
        int i = start;
        for(;sequence[i] < root;i++){ //从头开始遍历，数组中的值小于根节点 返回第一个不满足的i，说明i就是大于根节点的
        }
        int j = i;
        for (;j < end;j++) { //从此处开始将是右子树了，全部大于根节点，若小于根节点那就说明不匹配
            if (sequence[j] < root) { //如果当前的值
                return false;
            }
        }
        boolean left = VerifySquenceOfBST(sequence,start,i-1);  //递归 看左子树是否满足
        boolean right = VerifySquenceOfBST(sequence,i,end-1);  //递归 看右子树是否满足因为最后一项是根节点
        return left && right;
    }
}
