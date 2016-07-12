/**
 * 请设计一个算法，计算n的阶乘有多少个尾随零。
 给定一个int n，请返回n的阶乘的尾零个数。保证n为正整数。
 测试样例：
 5
 返回：1

 [分析]

 分解因子, 当且仅当 因子中出现 一对 (2,5)时, 最后结果会增加一个 trailing zero.

 1.  2的个数永远多于5个个数.

 2.  计算5的个数时, 最简单的方法是 SUM(N/5^1,  N/5^2, N/5^3...)

 */
public class Factor {
    public int getFactorSuffixZero(int n) {
        if(n<5) return 0;

        int res = 0;
        while (n/5 > 0){
            n /= 5;
            res += n;
        }
        return res;
    }
}