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

/**
 * 查找搜索算法
 * @authorliyunfei
 * @date2022/11/29
 **/
public class SearchTests {
       //折半查找
       int binarySearchIndex(int[] arr,int target,int left,int right){
           while (left<=right){
               int mid = (left + right) >> 1;
               if(arr[mid]==target)
                   return mid;
               else if (arr[mid]<target)
                   left = mid+1;
               else
                   right = mid-1;
           }
           return -1;//
       }
       int binarySearch(int []arr,int target){
           return binarySearchIndex(arr,target,0,arr.length-1);
       }
       @Test
       public void testSearch(){
           int[] arr1 = {1,3,5,6,9};
           System.out.println(binarySearch(arr1,3));
           System.out.println(binarySearch(arr1,5));
           System.out.println(binarySearch(arr1,6));
           int[] arr2 = {1,3,5,6,9,11};
           System.out.println(binarySearch(arr2,6));
           System.out.println(binarySearch(arr2,-6));
       }

}
