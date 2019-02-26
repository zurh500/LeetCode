public class ReplaceSpace5 {
    public static String replaceSpace1(StringBuffer str) {
        /*
         * 开辟新字符串
         */
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                buf.append(str.charAt(i));
            } else {
                buf.append("%20");
            }
        }
        return buf.toString();
    }

    public static String replaceSpace(StringBuffer str) {
        /*
         * 思路一：开辟新字符串
         *
         * 思路二：不开辟新字符串 1、从前往后替换，后面的字符不断往后移动，需要多次移动 时间复杂度是O(n^2)级别的
         * 2、从后往前替换，先计算需要多少空间，然后从后向前移动 则每个字符只移动一次，这样效率更高 步骤：
         * 1、将str转成字符数组，也可直接使用stringbuffer的charAt(index)方法来处理 2、统计字符数组长度，统计空格长度
         * 3、计算新数组长度 5、两个index，一个指向原长度在最后，一个指向新长度最后 6、从后向前判断第一个索引是否为空格，
         * 若不为空格，将该索引值赋给第二个索引位置的值 若为空格，将第二个索引处开始赋值 一定注意索引值和位置的关系
         */
        int spaceNum = 0; // 记录空格数

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                ++spaceNum;
            }
        }
        int oldIndex = str.length() - 1; // 原字符串索引
        int newLength = str.length() + spaceNum * 2; // 新长度
        int newIndex = newLength - 1; // 新字符串索引 但不是长度 只是索引值
        str.setLength(newLength); // 一定要设置新长度，不会回报StringIndexOutOfBoundsException错
        while (newIndex > oldIndex && oldIndex >= 0) {
            if (str.charAt(oldIndex) == ' ') { // 如果第一个指针指向空格
                str.setCharAt(newIndex, '0');
                str.setCharAt(--newIndex, '2'); // 要先-- 直接赋值了
                str.setCharAt(--newIndex, '%');
            } else {
                // 不为空格就将第一个索引的值赋给第二个索引值
                str.setCharAt(newIndex, str.charAt(oldIndex));
            }
            --oldIndex;
            --newIndex;
        }
        return str.toString();

    }

    public static void main(String[] args) {
        System.out.println(replaceSpace4(new StringBuffer("We Are Happy")));
    }

    public static String replaceSpace2(StringBuffer str) {
        /*
         * 第二种方式 使用转成字符串数组
         */
        char[] a = str.toString().toCharArray();
        int spaceNum = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == ' ')
                spaceNum++;
        }
        int newLength = (a.length + spaceNum * 2) - 1;
        char[] b = new char[newLength + 1]; //创建替换后的数组
        for (int i = a.length - 1; i >= 0; i--) { //从后向前遍历
            if (a[i] == ' ') {
                b[newLength--] = '0';
                b[newLength--] = '2';
                b[newLength--] = '%';

            } else {
                b[newLength--] = a[i];
            }
        }
        return String.valueOf(b);
    }

    public static String replaceSpace4(StringBuffer str) {
        int spaceNum = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ')
                spaceNum++;
        }
        int aIndex = str.length() - 1;
        str.setLength(str.length() + spaceNum * 2);
        int bIndex = aIndex + spaceNum * 2;
        for (int i = aIndex; i >= 0; i--) { //原字符串从后向前遍历到第一个
            if (str.charAt(i) == ' ') {
                str.setCharAt(bIndex--, '0');
                str.setCharAt(bIndex--, '2');
                str.setCharAt(bIndex--, '%');
            } else {
                str.setCharAt(bIndex--, str.charAt(i));
            }
        }
        return str.toString();
    }
}