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

package com.lyf.meituan;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author liyunfei
 **/
public class Main1 {

    /**
     * 3 4 5
     * 1 2 3
     * 3 2 1
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int H = in.nextInt();
            int A = in.nextInt();
            Node[] nodes = new Node[n];
            for(int i=0;i<n;i++){
                nodes[i] = new Node();
                nodes[i].h = in.nextInt();
            }
            for(int i=0;i<n;i++){
                nodes[i].a = in.nextInt();
            }
            // 降序贪心策略
            dfs(nodes,H,A,0);
            System.out.println(rs);
        }
    }

    static LinkedList<Node> choices = new LinkedList<>();
    static int rs = 0;
    static void dfs(Node[]nodes,int H ,int A,int index){
         if(index>=nodes.length){
             rs = Math.max(rs,choices.size());
         }
         for(int i=0;i<nodes.length;i++){
             Node needNode = nodes[i];
             if(needNode.getA() >= A || needNode.getH() >= H || choices.contains(needNode)){
                 continue;
             }
             choices.addLast(needNode);
             dfs(nodes,needNode.getH(),needNode.getA(),i+1);
             choices.removeLast();
         }
    }

//   static int  handle(Node[]nodes,int H,int A){
//        int rs  = 0;
//        if(nodes==null || nodes.length==0){
//            return rs;
//        }
//        for(Node node:nodes){
//            if(H>=node.h && A>=node.a){
//                rs++;
//                H = node.h;
//                A = node.a;
//            }
//        }
//        return rs;
//    }

    private static class Node{
        int h,a;

        public Node() {
        }

        public Node(int h, int a) {
            this.h = h;
            this.a = a;
        }

        public int getH() {
            return h;
        }

        public int getA() {
            return a;
        }
    }

}
