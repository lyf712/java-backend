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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * @authorliyunfei
 * @date2022/12/20
 **/
public class FileTests {
    final String path = "C:\\Program Files (x86)\\Sangfor\\SSL\\Log\\SangforServiceClient.exe.log";
    final long rate = 5;
    @Test
    public void readFile() throws IOException, InterruptedException {
        File file = new File(path);
        if(file.exists()){
            FileInputStream inputStream  = new FileInputStream(file);
            byte[]bytes = new byte[1024];
            while(inputStream.read(bytes)!=-1){
                System.out.println(new String(bytes, StandardCharsets.UTF_8));
                TimeUnit.SECONDS.sleep(rate);
            }
            inputStream.close();
        }
    }
}
