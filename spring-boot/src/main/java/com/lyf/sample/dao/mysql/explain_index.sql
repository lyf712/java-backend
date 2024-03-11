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

## comprehensive index and know about explain command use
                  ## null
#explain SELECT * FROM wu_wei.consult;
## key ,primary
                 ## order by id

create index test_index on wu_wei.consult(title);
##Using index condition; Using filesort
## type range
#从最好到最差依次是：
# system > const > eq_ref > ref > range > index > All。
# system : 表中只有一条记录 ( 等于系统表 ) ，这是const类型的特例，平时不会出现，这个可以忽略不计。
# const : 表示通过索引一次找到了，const用于primary key 或者 unique 索引。因为只匹配一行数据，所以很快，将主键置于where列表中，mysql 就能将该查询转换成一个常量。
# eq_ref : 唯一性索引扫描，对于每个索引键，表中只有一条记录于之匹配。常见于主键和唯一索引扫描。
# ref : 非唯一性索引扫描，返回匹配某个单独值的所有行，本质上也是一种索引访问，它返回所有匹配某个单独值的行，然而，它可能会找到多个符合条件的行，所以他应该属于查找和扫描的混合体。
# range : 只检索给定范围的行，使用一个索引来选择行。keyl列显示使用了哪个索引，一般就是在你的where 语句中出现了between、< 、> 、in 等的查询。这种范围扫描比全表扫描要好，因为它只需要开始于索引的某一点，二结束于另一点，不用扫描全部的索引。
# index :  Full index scan , index 与All 区别为index类型只遍历索引树。这通常比All块，因为索引文件通常比数据文件小。（也就是说虽然All 和 index 都是读全表，但是index 是从索引中读取的，而all 是从硬盘中读取的）。
# all :  Full table Scan，将遍历全表以找到匹配的行。
#
explain SELECT * FROM wu_wei.consult where title like 'ok' and state ='ok';# order by id;