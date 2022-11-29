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

package com.lyf.datastructurealg;

import org.junit.Test;

import java.util.Arrays;

/**
 * 排序算法：快排
 * @authorliyunfei
 * @date2022/11/26
 **/
public class SortTests {
    /**
     * QuickSort
     * https://blog.csdn.net/LiangXiay/article/details/121421920
     */

    public void quickSort(int[]arr,int left,int right){
           if(left>=right)
               return;
           int key = partition(arr,left,right);
           quickSort(arr,left,key-1);
           quickSort(arr,key+1,right);
    }
    public void swap(int[]arr,int x,int y){
           int tmp = arr[x];
           arr[x] = arr[y];
           arr[y] = tmp;//
    }
    public int partition(int[]arr,int left,int right){
           int key = left;// 默认为left第一个
           // 处理排序
           // 将小于 arr[key]的值放左边，大于的放右边
           int index = key+1;
           while (index<=right){
               if(arr[index]<arr[key])
               {
                   /**
                    * 该处的交换逻辑需要理一理：归纳来说就是 让小于key的交换至左边，大的保持在右边
                    * 随着交换，key会移动
                    */
                   // 将index的值放 key的位置，key的值放key+1处， key+1的值放index
                   // key+1处已保证 大于key处的值了，若 key+1==index则保持不变，相对于只有key和key+1的交换
                   swap(arr,key+1,index);// index的值在key+1处，key+1的值移到
                   swap(arr,key,key+1);
                   // key的值应该移到key+1处
                   key++;
               }
               index++;
               // 思路二 先进行left,right的移动，保证left的小于key,right大于key，否则退出，
               // 然后交换 left,right 此时left,right刚好是相反的要求，交换则更好解决不满足的情况
               // 最后循环跳出后在交换一下，
               /*
       	while (left < right && a[right] >= a[key])//如果右比key小就退出循环
			right--;
		while (left < right && a[left] <= a[key])//如果左比key大就退出循环
			left++;
		swap(&a[left], &a[right]);//交换左右
                */
           }
           return key;
    }

    @Test
    public void test(){
          int arr[]={2,5,1,3,8,7,4};
          System.out.println("partition:"+partition(arr,0,arr.length-1));
          quickSort(arr,0,arr.length-1);
          System.out.println(Arrays.toString(arr));
    }

    // 归并排序


}
