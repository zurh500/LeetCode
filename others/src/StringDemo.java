import java.util.Arrays;

public class StringDemo {

    /*
    模拟trim
     */
    public static String myTirm(String str){
        int start = 0;
        int end = str.length()-1;
        while(start < end && str.charAt(start) == ' '){
            start++;
        }
        while (start < end && str.charAt(end) == ' ') {
            end--;
        }
        return str.substring(start, end+1);
    }

    /*
    将一个字符串进行反转。将字符串中指定部分进行反转。
    比如将“abcdefg”反转为”abfedcg”
     */
    public static String reverseString(String str, int start, int end) {
        /*
            1、先将字符串转成字符数组
            2、根据指定的start和end，对两个位置的数据进行交换
            3、交换完进行start++ end--
         */
        char[] chars = str.toCharArray();
        for (int x = start, y = end; x < y; x++, y--) {
            char temp = chars[x];
            chars[x] = chars[y];
            chars[y] = temp;
        }
        return new String(chars);
    }

    /*
      获取一个字符串在另一个字符串中出现的次数。
      比如：获取“ ab”在 “abkkcadkabkebfkabkskab”
      中出现的次数

     */
    public static int getTime(String str,String key) {
        int count = 0; //局部变量必须初始化
        int s;
        while ((s = str.indexOf(key)) != -1) {
            count ++;
            str = str.substring(s + key.length());
        }
        return count;
    }

    /*
     获取两个字符串中最大相同子串。比如：
     str1 = "abcwerthelloyuiodef“;str2 = "cvhellobnm"
        提示：将短的那个串进行长度依次递减的子串与较长
     的串比较。
     */
    public static String theSameStr(String str1,String str2) {
        String max = (str1.length() > str2.length()?str1:str2 );
        String min = (str1.length() < str2.length()?str1:str2 );
        for (int x = 0;x < min.length();x++){
            for (int y = 0,z = min.length() - x;z <= min.length();y++,z++){
                String str = min.substring(y, z);
                if (max.contains(str)) {
                    return str;
                }
            }
        }
        return null;
    }




    /*
    对字符串中字符进行自然顺序排序。
    提示：
    1）字符串变成字符数组。
    2）对数组排序，选择，冒泡，Arrays.sort();
    3）将排序后的数组变成字符串。
     */
    public static String strSort(String str){
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static void main(String[] args){
        String s = "  5olj h ";
        System.out.println(myTirm(s));
        String s2 = "abckils";
        System.out.println(reverseString(s2,1,4));
        String s3 = "abhudsdfabjkfdsuabfsd";
        System.out.println(getTime(s3,"ab"));
        System.out.println(theSameStr("abcwerthellotlloyuiodef", "cvhellobnm"));
        String s5 = "likfashcb";
        System.out.println(strSort(s5));

        String text = "";
        long startTime = 0L;
        long endTime = 0L;
        StringBuffer buffer = new StringBuffer("");
        StringBuilder builder = new StringBuilder("");
        startTime = System.currentTimeMillis();
        for(int i = 0;i<20000;i++){
            buffer.append(String.valueOf(i));}
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer的执行时间："+(endTime-startTime));
        startTime = System.currentTimeMillis();
        for(int i = 0;i<20000;i++){
            builder.append(String.valueOf(i));}
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder的执行时间："+(endTime-startTime));
        startTime = System.currentTimeMillis();
        for(int i = 0;i<20000;i++){
            text = text + i;}
        endTime = System.currentTimeMillis();
        System.out.println("String的执行时间："+(endTime-startTime));
    }

}
