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
import java.util.LinkedList;
import java.util.List;

/**
 * @authorliyunfei
 * @date2022/12/24
 **/
public class Template2 <T>{
       List<List<T>> rs = new ArrayList<>();
       LinkedList<T> path = new LinkedList<>();
       /*
        * index:选择下标，通过该下标反应选择元素
        * choiceList:可选择的元素
        */
       private void backTrack(int index,List<T> choiceList){
               // 进行将符合要求的选择路径path，往往有多种path
               // 可根据index，path.size()等元素去做条件，进入之后 还可进行path的条件进步判断
               if(path.size()==choiceList.size()){
                   rs.add(new ArrayList<>(path));// java,通过构造器copy
                   return;
               }
               for (int i=index;i<choiceList.size();i++){
                   if(!checkValid()){continue;}
                   path.add(choiceList.get(i));
                   backTrack(i+1,choiceList);//纵深，下次选择 - 树的高度
                   path.removeLast();//回退，保证路径的记录跟着回退
               }
       }
       private boolean checkValid(){
               // -- 例如棋盘检查，范围检查，要求检查等
               // 也可在此进行预测、剪裁，例如选择的元素已达标则没有必要继续选择
               // 做去重处理！！
               return true;
       }

}
