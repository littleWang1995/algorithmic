package com.wj.array;

/*
    螺旋矩阵
    重点：画每条边都遵循统一的原则，即循环不变量，画头不画尾（不包含尾节点）
 */
public class MatrixTest {
    public static void main(String[] args) {
        int n = 5;
        int res[][] = genarateMatrix(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(res[i][j]+" ");
            }
            System.out.println("");
        }

    }

    /**
     * 生成一个螺旋矩阵
     * @param n
     * @return
     */
    private static int[][] genarateMatrix(int n) {
        int[][] res = new int[n][n];
        //循环次数,循环的圈数等于n/2
        int loop = 0;
        int start = 0;//表示每圈循环的起始坐标比如0,0 -> 1,1 -> 2,2
        int i,j;//用来表示坐标，默认i是横坐标，j是纵坐标
        int count = 1;//填充的数字

        while (loop < n/2){//n =5,loop = 0,1
            loop++;
            //上-从左往右
            for (j = start; j < n - loop; j++){//n - loop的意思是，每循环一圈，每条路径上的个数要少【循环的圈数】个
                res[start][j] = count++;
            }

            //右-从上往下
            for (i = start; i < n - loop; i++){
                res[i][j] = count++;
            }
            //当n=5时，此时j=4,i=4，start=0
            //下-从右往左
            for (;j >= loop; j--){
                res[i][j] = count++;
            }

            //左-从下往上
            for (;i >= loop; i--){
                res[i][j] = count++;
            }

            start++;
        }

        //当n为奇数时，填充中心点
        if (n%2 ==1){
            res[start][start] = count;
        }

        return res;
    }
}
