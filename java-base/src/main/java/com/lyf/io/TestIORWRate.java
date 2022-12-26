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

package com.lyf.io;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @authorliyunfei
 * @date2022/12/25
 **/
public class TestIORWRate {
    /**
     * ------
     * 对于固态硬盘的读取时间：us级别；机械硬盘：ms级别
     * 地址总线 32bit则可操作 4GB？
     * 内存：100ns级别 0.1us -> 640 MB --
     * Cache Line一次性 64Byte【 64 * 1/200us = 320KB/s??】
     * https://www.bbsmax.com/A/kmzLAnnNJG/
     * ------
     */
    @Test
    public void testRW() throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("");
        //fileInputStream.read() -> 通过native方法，C语言调用OS的库--
        //TODO 待文件系统、IO的学习
    }

}
