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

package com.lyf.alg.carl.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @authorliyunfei
 * @date2022/12/22
 **/
public class NQueen {
    List<List<String>> rs = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        boolean[][] plate = new boolean[n][n];
        backTrack(0,n,plate);
        return rs;
    }
    private void backTrack(int start,int n,boolean[][]plate){// 下第几行
        if(start>=n){//下标从0开始
            // 将棋盘加入结果 n^2
            List<String> path = new ArrayList<>();
            for(int i=0;i<n;i++){
                String line = "";
                for(int j=0;j<n;j++){
                    line=line+(plate[i][j]==true?"Q":".");
                }
                path.add(line);
            }
            rs.add(path);
            return;
        }

        for(int i=0;i<n;i++){// 选择 列
            if(!isValid(plate,n,start,i)){continue;}// 不合法，继续探索
            plate[start][i] = true;
            backTrack(start+1,n,plate);
            plate[start][i]= false;//回退
        }
    }

    boolean isValid(boolean[][]plate,int n,int row,int col){
        //皇后可以攻击与之处在同一行或同一列或同一斜线上

        //    for(int i=0;i<n;i++){
        //          int rowNum = 0;//该行true的数量
        //          int colNum = 0;
        //          for(int j=0;j<n;j++){
        //              if(plate[i][j]==true) rowNum++;
        //              if(plate[j][i]==true) colNum++;//该列的数量
        //          }
        //          if(rowNum>1||colNum>1)return false;
        //    }

        // 只需考虑下棋的这一步

        for(int i=0;i<n;i++){
            if(i!=col&&plate[row][i]==true) return false;
            if(i!=row&&plate[i][col]==true) return false;// Java 可直接 if(true) >
        }
        int i=row,j=col;
        // 往下走
        while(++i<n && ++j<n){
            if(plate[i][j]==true) return false;
        }
        i=row;
        j=col;
        // 上走
        while(--i>=0 && --j>=0){
            if(plate[i][j]==true) return false;
        }
        //右边的斜线
        i=row;
        j=col;
        while(--i>=0&&++j<n){
            if(plate[i][j]==true) return false;
        }
        i=row;
        j=col;
        while(++i<n&&--j>=0){
            if(plate[i][j]==true) return false;
        }
        return true;
    }
}
