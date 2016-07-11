/**题目描述

 请编写一个函数，函数内不使用任何临时变量，直接交换两个数的值。
 给定一个int数组AB，其第零个元素和第一个元素为待交换的值，请返回交换后的数组。
 测试样例：
 [1,2]
 返回：[2,1]

 解答：
 设a=1,b=6.
 分3步：
 1) b' = a+b = 7
 2) a' = b'-a = a+b-a = b = 6
 3) b''= b'-a' = a+b-b = a = 1
 交换完成
 */
import java.util.*;

public class Exchange {
    public int[] exchangeAB(int[] AB) {
        // write code here
        AB[1] = AB[0] + AB[1];
        AB[0] = AB[1] - AB[0];
        AB[1] = AB[1] - AB[0];
        return AB;
    }
}
