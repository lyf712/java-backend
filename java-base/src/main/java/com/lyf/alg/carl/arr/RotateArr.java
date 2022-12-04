/*
 *    Copyright 1999-2022  lyf712
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.lyf.alg.carl.arr;

/**
 * @authorliyunfei
 * @date2022/12/4
 **/
public class RotateArr {
    public static void main(String[] args) {
        System.out.println(generateMatrix(3));
    }
    public static int[][] generateMatrix(int n) {
        int index = 1;
        int[][]arr = new int[n][n];
        int x=0,y=0;
        //Arrays.fill(arr,0);
        while(index<=n*n){
            // 像右移动
            while(y<n && arr[x][y]==0){
                arr[x][y++] = index++;
            }
            y--;// 回退
            x++;//向下走一个!!易忘
            // 向下
            while(x<n && arr[x][y]==0){
                arr[x++][y] = index++;
            }
            x--;

            y--;// 向左
            while(y>=0 && arr[x][y]==0){
                arr[x][y--] = index++;
            }
            y++;
            x--;
            while(x>=0 && arr[x][y]==0){
                arr[x--][y] = index++;
            }
            x++;
            y++;
            // index++;
        }
        return arr;
    }
}
