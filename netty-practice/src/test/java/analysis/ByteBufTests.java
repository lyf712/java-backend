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

package analysis;

import io.netty.buffer.*;
import org.junit.Test;

import java.nio.ByteBuffer;

/**
 * @author liyunfei
 **/
public class ByteBufTests {

    /**
     * 设计思想：
     * 本质还是生产 - 消费
     *
     */


    /**
     *
     *  [  position   limit    capacity]
     *  remaining return limit-position [可读区间],
     *            capacity-limit [可写区间]
     *            position [已读区间]
     *
     *
     *  flip limit=position,position=0
     *  rewind position = 0;
     *  clear  position = 0; limit = capacity
     *  mark   mark = position;
     *  compact 释放--
     * 测试NIO原生的ByteBuffer
     */
    @Test
    public void test1(){
        ByteBuffer byteBuffer = ByteBuffer.allocate(100);
        String content = "I Love Netty!";
//        byteBuffer.putLong(1L);
//        byteBuffer.putInt(2);
        byteBuffer.put(content.getBytes());
//        System.out.println(byteBuffer.getLong(0));
//        System.out.println(byteBuffer.getInt(2));

        // 尝试不手动调flip看看，，那么remaining 则是 limit=capacity=100,position=13,,,get()的remainning则是87
        byteBuffer.flip();
        //
        // byteBuffer.compact()

        // limit-position
        System.out.println(byteBuffer.remaining());
        // 声明数组
        byte[]arr = new byte[byteBuffer.remaining()];

        // ScopedMemoryAccess:直接内存；；；； Heap---ByteBuffer
        // offset(0-arr.length)---去调    get()   return ((SCOPED_MEMORY_ACCESS.getByte(scope(), null, ix(nextGetIndex()))));
        // ix(nextGetIndex()) -- position+offset
        System.out.printf("position:%d,limit:%d,capacity:%d \n",byteBuffer.position(),byteBuffer.limit(),byteBuffer.capacity());

        byteBuffer.get(arr);
        System.out.println(new String(arr));

    }

    @Test
    public void test2(){
        ByteBuffer byteBuffer = ByteBuffer.allocate(100);
        byteBuffer.putInt(1);
        byteBuffer.putLong(2L);
        // 放完数据需要手动调用一下
        byteBuffer.flip();
        //position  +  4
        System.out.println(byteBuffer.getInt());
        System.out.println(byteBuffer.getLong());

    }


    // 测试netty 的 ByteBuf

    /**
     *
     * [readIndex    , writeIndex     capacity]
     * 读写分离--
     *
     *
     *
     */

    @Test
    public void test3(){
        // ByteBuf在设计时，方法都 非public了，为了保证资源安全，，，，采用工厂模式 ，获取----
        // 思考再业务开发的场景：：：例如缓存manager设计单例模式----

        // 几个关键概念
        // 1.指针的读写问题，操作数据
        // 2.对ByteBuffer兼容的问题
        // 3.堆外堆内，，，对象池与否

        //ByteBuf buf = new ByteBuffer()

        //ByteBuf buf = new UnpooledUnsafeHeapByteBuf(new UnpooledByteBufAllocator(false),1,1);
        ByteBufAllocator allocator = new UnpooledByteBufAllocator(false);
        allocator.directBuffer();
        allocator.buffer();
        allocator.heapBuffer();

        // 本质还是通过allocator进行分配
        /**
         *     static {
         *         ALLOC = UnpooledByteBufAllocator.DEFAULT;
         *         BIG_ENDIAN = ByteOrder.BIG_ENDIAN;
         *         LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
         *         EMPTY_BUFFER = ALLOC.buffer(0, 0);
         *     }
         */
        // ALLOC.---
        ByteBuf buf1 = Unpooled.buffer();
        ByteBuf buf2 = Unpooled.directBuffer();
        String content = "I Love Netty!";
        buf1.writeBytes(content.getBytes());
        byte[] bytes = new byte[buf1.readableBytes()];
        buf1.readBytes(bytes);
        System.out.println(new String(bytes));

        //buf1.unwrap()
        buf1.nioBuffer();

        // 对象池---
        PooledByteBufAllocator pooledByteBufAllocator = new PooledByteBufAllocator();
        pooledByteBufAllocator.buffer();


        // AbstractReferenceCountedByteBuf

    }

}

