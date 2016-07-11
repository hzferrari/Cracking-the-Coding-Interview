/**
 * 题目描述

 对于一个给定的井字棋棋盘，请设计一个高效算法判断当前玩家是否获胜。
 给定一个二维数组board，代表当前棋盘，其中元素为1的代表是当前玩家的棋子，为0表示没有棋子，为-1代表是对方玩家的棋子。
 测试样例：
 [[1,0,1],[1,-1,-1],[1,-1,0]]
 返回：true

 思路：
 1）判断1与-1的数量的差值是否不大于1，且1的数量应大于2小于6；
 2）判断是否3连（恒，竖，斜）
 这里用的方法是列出所有赢的模式，一共8种。

 错误注意：Set不能用来比较两个数组是否相同！！
 */
import java.util.*;
public class Board {
    public boolean checkWon(int[][] board) {

        //用Set来判断是错误的，set会出现一样的（数值相同的）两个数组
//        HashSet<int[]> parttenSet = new HashSet<int[]>(8);
//        parttenSet.add(new int[]{0, 1, 2});
//        parttenSet.add(new int[]{3, 4, 5});
//        parttenSet.add(new int[]{6, 7, 8});
//        parttenSet.add(new int[]{0, 3, 6});
//        parttenSet.add(new int[]{1, 4, 7});
//        parttenSet.add(new int[]{2, 5, 8});
//        parttenSet.add(new int[]{0, 4, 8});
//        parttenSet.add(new int[]{2, 4, 6});

        int[][] parttenSet = new int[][]{{0,1,2},{3, 4, 5},{6, 7, 8},{0, 3, 6},{1, 4, 7},
                {2, 5, 8},{0, 4, 8},{2, 4, 6}};
        int whiteNum = 0;
        int blackNum = 0;
        List<Integer> whiteLocation = new LinkedList<Integer>();
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] == 1){
                    whiteNum++;
                    whiteLocation.add(3*i+j);   //记录位置（转换成012345678）
                }else if(board[i][j] == -1){
                    blackNum++;
                }
            }
        }

        //判断
        if(whiteNum <3 && whiteNum >5 && Math.abs(whiteNum - blackNum) > 1)
            return false;

        int[] whitePartten = new int[3];
        for(int i=0; i<whiteLocation.size()-2; i++){
            for(int j=i+1; j<whiteLocation.size()-1; j++){
                for(int k=j+1; k<whiteLocation.size(); k++){
                    whitePartten[0] = whiteLocation.get(i);
                    whitePartten[1] = whiteLocation.get(j);
                    whitePartten[2] = whiteLocation.get(k);
                    //遍历判断是否胜利
                    for(int m=0; m<parttenSet.length; m++){
                        if(Arrays.equals(parttenSet[m],whitePartten)) return true;
                    }
                }
            }
        }
        //所有模式都不匹配
        return false;

    }
    public static void main(String[] args) {
        int[][] test = new int[][]{{0,0,1},{1,-1,-1},{1,-1,0}};
        Board a = new Board();
        System.out.println(a.checkWon(test));

    }
}
