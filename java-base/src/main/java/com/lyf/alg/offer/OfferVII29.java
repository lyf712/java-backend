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

package com.lyf.alg.offer;

import java.util.Stack;

/**
 * @authorliyunfei
 * @date2023/1/4
 **/
public class OfferVII29 {
    public int[] spiralOrder(int[][] matrix) {
        int count = 0;
        if(matrix.length==0||matrix[0].length==0) return new int[0];
        int lenX = matrix[0].length,lenY=matrix.length;
        int len = lenX*lenY;
        int []rs = new int[len];
        int x=0,y=0;//matrix[y][x];
        int q = 0;
        while(count<len){
            while(x<lenX-q){
                rs[count] = matrix[y][x];
                x++;
                count++;
                if(count>=len) break;
            }
            x--;
            y++;
            if(count>=len) break;
            while(y<lenY-q){
                rs[count] = matrix[y][x];
                y++;
                count++;
                if(count>=len) break;
            }
            y--;
            x--;
            if(count>=len) break;
            while(x>=q){
                rs[count] = matrix[y][x];
                x--;
                count++;
                if(count>=len) break;
            }
            x++;
            y--;
            if(count>=len) break;
            q++;//最后一圈
            while(y>=q){
                rs[count] = matrix[y][x];
                y--;
                count++;
                if(count>=len) break;
            }
            y++;
            x++;
            // q++;
        }
        return rs;
    }

    //通过固定边界、调整伸缩
    public int[] spiralOrder2(int[][] matrix) {
        if(matrix.length == 0) return new int[0];
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;
        int[] res = new int[(r + 1) * (b + 1)];
        while(true) {
            for(int i = l; i <= r; i++) res[x++] = matrix[t][i]; // left to right.
            if(++t > b) break;
            for(int i = t; i <= b; i++) res[x++] = matrix[i][r]; // top to bottom.
            if(l > --r) break;
            for(int i = r; i >= l; i--) res[x++] = matrix[b][i]; // right to left.
            if(t > --b) break;
            for(int i = b; i >= t; i--) res[x++] = matrix[i][l]; // bottom to top.
            if(++l > r) break;
        }
       // new Stack<>().isEmpty();

        return res;
    }
}
