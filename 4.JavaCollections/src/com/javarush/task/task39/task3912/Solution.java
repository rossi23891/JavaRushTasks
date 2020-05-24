package com.javarush.task.task39.task3912;

/* 
Максимальная площадь
*/

import sun.awt.X11.XFocusProxyWindow;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {

        int[][] array1 = {
                {1, 1, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {0, 1, 1, 1, 1}
        };

        int[][] array2 = {
                {1, 1, 0, 1, 0},
                {0, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1},
                {0, 1, 1, 1, 1}
        };

        int[][] array3 = new int[0][0];

        int[][] array4 = {
                {1, 1, 0, 1}
        };

        int[][] array5 = {
                {1},
                {1},
                {0},
                {1}
        };

        int[][] array6 = {
                {0, 0, 0, 0}
        };

        int[][] array7 = {
                {0},
                {0},
                {0},
                {0}
        };

        int[][] array8 = {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };

        int[][] array9 = {
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1}
        };

        int[][] array10 = {
                {1, 1, 0, 1},
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 1, 1, 1},
                {0, 1, 1, 1}
        };
        int[][] array11 = {
                {0, 1},
                {1, 0}
        };

        System.out.println(maxSquare(array1));
        System.out.println(maxSquare(array2));
        System.out.println(maxSquare(array3));
        System.out.println(maxSquare(array4));
        System.out.println(maxSquare(array5));
        System.out.println(maxSquare(array6));
        System.out.println(maxSquare(array7));
        System.out.println(maxSquare(array8));
        System.out.println(maxSquare(array9));
        System.out.println(maxSquare(array10));
        System.out.println(maxSquare(array11));
    }

        //public static int maxSquare2 ( int[][] matrix){
        //    int maxSize = 0;
        //    int currentSize = 0;
        //    for (int i = 0; i < matrix.length; i++) {
        //        for (int j = 0; j < matrix[0].length; j++) {
        //            if (matrix[i][j] == 1) {
        //                currentSize = findSquare(matrix, i, j);
        //                if (currentSize > maxSize) {
        //                    maxSize = currentSize;
        //                }
        //            }
        //        }
        //    }
        //    return maxSize * maxSize;
        //}
        //
        //public static int findSquare ( int[][] matrix, int a, int b){
        //    int currentSize = 0;
        //    for (int j = b, i = a; j < matrix[0].length; j++) {
        //        if (matrix[i][j] == 1) {
        //            currentSize++;
        //        } else {
        //            break;
        //        }
        //    }
        //    int currentSize2 = 0;
        //    for (int i = a, j = b; i < matrix.length; i++) {
        //        if (matrix[i][j] == 1) {
        //            currentSize2++;
        //        } else {
        //            break;
        //        }
        //    }
        //    return Math.min(currentSize, currentSize2);
        //}

        public static int maxSquare(int[][] matrix){
        if (matrix.length==0){
            return 0;
        }
        int[][] bigMatrix = new int[matrix.length+1][matrix[0].length+1];
        int max = 0;
            for (int i = 0; i < bigMatrix.length; i++) {
                bigMatrix[i][0]=0;
            }
            for (int j = 0; j < bigMatrix[0].length; j++) {
                bigMatrix[0][j]=0;
            }
            for (int i = 1; i < bigMatrix.length; i++) {
                for (int j = 1; j < bigMatrix[0].length; j++) {
                    if(matrix[i-1][j-1]==0){
                        bigMatrix[i][j]=0;
                    }else{
                        int put = findMin(bigMatrix[i][j - 1], bigMatrix[i - 1][j - 1], bigMatrix[i - 1][j]) + 1;
                        bigMatrix[i][j]=put;
                        if(put>max){
                            max=put;
                        }
                    }
                }
            }
            return max*max;
        }

        public static  int findMin(int a, int b, int c){
        int min1 = Math.min(a,b);
        return Math.min(min1,c);
        }
    }
