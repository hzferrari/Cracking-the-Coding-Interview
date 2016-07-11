/**
 * 请编写一个方法，找出两个数字中最大的那个。条件是不得使用if-else等比较和判断运算符。
 给定两个int a和b，请返回较大的一个数。若两数相同则返回任意一个。
 测试样例：
 1，2
 返回：2

 思路：
 1) b' = a-b;
 2) 符号位：x = b'>>31  若a>b，则x=0, 若a<b,则x=1
 3) return a = a-b'&x
    如果a>b,则a = a-(a-b)*0 = a
    如果a<b,则a = a-(a-b)*1 = b
 */

public class Max {
    public int getMax(int a, int b) {
        // write code here
        b = a - b;
        a = a - ( b&(b>>31 ));  //!!注意-号的优先级比&高
        return a;
    }

    public static void main(String[] args) {
        Max a = new Max();
        a.getMax(127201,33);
    }
}