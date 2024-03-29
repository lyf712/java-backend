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

package com.lyf.base.serial;

import com.google.common.collect.Lists;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;

/**
 * @author liyunfei
 **/
public class SerialOptMain {
    final static String FILE_PATH = "E:\\JavaProjects\\LearnProjects\\java-backend\\java-guide\\java-part\\src\\main\\java\\com\\lyf\\base\\serial\\test.txt";
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(Files.newOutputStream(new File(FILE_PATH).toPath()));
        SerialObject serialObject = new SerialObject(1L,3L);
//        serialObject.setList(Lists.newArrayList("1","2"));
//        objectOutputStream.writeObject(serialObject);

        ObjectInputStream objectInputStream = new ObjectInputStream(Files.newInputStream(new File(FILE_PATH).toPath()));
//        serialObject = (SerialObject) objectInputStream.readObject();
//        System.out.println(serialObject);

        ArrayList<String> arrayList = Lists.newArrayList("1","2");
        objectOutputStream.writeObject(arrayList);
        objectInputStream = new ObjectInputStream(Files.newInputStream(new File(FILE_PATH).toPath()));
        arrayList = (ArrayList<String>) objectInputStream.readObject();
        System.out.println(arrayList);
    }


}
