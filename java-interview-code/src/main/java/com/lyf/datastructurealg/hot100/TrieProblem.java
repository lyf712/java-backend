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

package com.lyf.datastructurealg.hot100;

/**
 * @author liyunfei
 **/
public class TrieProblem {
    class Trie {
        Trie[] children;
        boolean isEnd;
        public Trie() {
            children = new Trie[26];// 此处是否可优化，采用Set的方式去--，但是查找时就麻烦了
            isEnd = false;
        }

        public void insert(String word) {
            Trie node = this;
            for(int i=0;i<word.length();i++){
                char ch = word.charAt(i);
                int index = ch-'a';
                if(node.children[index]==null){// 通过下标是否为空去--判断是否加入，，空间复杂度过大？
                    node.children[index] = new Trie();
                }
                node = node.children[index];
            }
            node.isEnd=true;//最后一个节点才设置为终点
        }

        public boolean search(String word) {
            Trie node = searchPreffix(word);
            return node!=null && node.isEnd;
        }

        public boolean startsWith(String prefix) {
            return searchPreffix(prefix)!=null;
        }

        private Trie searchPreffix(String str){
            Trie node = this;
            for(int i=0;i<str.length();i++){
                char ch = str.charAt(i);
                int index = ch-'a';
                if(node.children[index]==null){
                    return null;
                }
                node = node.children[index];
            }
            return node;
        }
    }


}
